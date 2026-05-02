package com.byzantander;

import bftsmart.tom.MessageContext;
import bftsmart.tom.ServiceReplica;
import bftsmart.tom.server.defaultservices.DefaultSingleRecoverable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.byzantander.bank.Bank;
import com.byzantander.bank.impl.MaliciousBank;
import com.byzantander.bank.impl.HonestBank;
import com.byzantander.BankMessage;

public final class BankServer extends DefaultSingleRecoverable {

    private Bank bankState;

    public BankServer(int id, Bank state) {
        this.bankState = state;
        new ServiceReplica(id, this, this);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage BankServer <server id> [malicious]");
            System.exit(-1);
        }
        boolean isMalicious = args.length > 1 && args[1].equals("malicious");
        Bank state = isMalicious ? new MaliciousBank(): new HonestBank();

        new BankServer(Integer.parseInt(args[0]), state);
    }

    @Override
    public byte[] appExecuteUnordered(byte[] command, MessageContext msgCtx) {         
        // WIP
    }
  
    @Override
    public byte[] appExecuteOrdered(byte[] command, MessageContext msgCtx) {
        // WIP
        BankMessage<K, V> response = new BankMessage(command);
        BankMessage<K, V> request = BankMessage.fromBytes(command);
        // missing import
        BankRequestType cmd =request.getType();

        // implement
        // para bankState.createAccount preciso de enviar msgCtx.getSequence() que será o meu id
        // depois para os outros métodos farei
        // int to = dis.readInt();
        // int from = dis.readInt();
        // long amount = dis.readLong();

        // if cmd = CREATE_ACCOUNT:
        // int id = msgCtx.getSequence();
        // bankState.createAccount(id, amount);
        // response.setType(CREATE_ACCOUNT_REPLY);
        // response.setAccountId(id);
        // return BankMessage.toByts(response);
        // else if cmd = ...
        // ...
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public void installSnapshot(byte[] state) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(state);
            ObjectInput in = new ObjectInputStream(bis);
            this.bankState = (Bank) in.readObject();
            in.close();
            bis.close();
        } catch (IOException e) { // maybe add another exception for casting error
            System.err.println("[ERROR] Error deserializing state: "
                    + e.getMessage());
        }
    }

    @Override
    public byte[] getSnapshot() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeInt(bankState);
            out.flush();
            bos.flush();
            out.close();
            bos.close();
            return bos.toByteArray();
        } catch (IOException ioe) {
            System.err.println("[ERROR] Error serializing state: "
                    + ioe.getMessage());
            return "ERROR".getBytes();
        }
    }
}