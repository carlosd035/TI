package com.byzantander;

import java.io.ByteArrayInputStream;
// ....

import bftsmart.tom.ServiceProxy;

import com.byzantander.BankMessage;

public class BankClient {
    
    ServiceProxy serviceProxy;

    public BankClient(int clientId) {
        serviceProxy = new ServiceProxy(clientId);
    }

    /*
    i will have something like
    client = BankClient(id);
    int id_1 = client.createAccount("100");
    mas aqui no client tem de haver uma conversão
    10 euros -> 1000
    para que 
    10.50 -> 1050
    ou seja,
    1 -> 100
    depois para mostrar ao user penso que so tenho de fazer
    print(saldo / 100 + "euros"), tenho de ver os tipos
    */
    public int createAccount(String initialBalanceStr) {
        java.math.BigDecimal value = new java.math.BigDecimal(initialBalanceStr);
        long initialBalance = value.setScale(2, RoundingMode. HALF_UP)
                                   .movePointRight(2)
                                   .longValue();
        byte[] rep;
        try {
            BankMessage<K, V> request = new BankMessage<K, V>();
            request.setType(..........);

            // invokes BFT-SMaRt
            rep = this.serviceProxy.invokeOrdered(BankMessage.toBytes(request));
        } catch (IOException e) {
            System.out.println("Failed to  ..... " + e.getMessage());
            return null;
        }
        if (rep.length == 0) {
            return null;
        }

        try {
            BankMessage<K, V> response = BankMessage.fromBytes(rep);
            return response.getAccountId();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Failed to deserialized response of ....." + ex.getMessage());
            return null;
        }
    }

    // similar idea for other
    public XXXX deposit(int to, String amountStr) {
        java.math.BigDecimal value = new java.math.BigDecimal(amountStr);
        long initialBalance = value.setScale(2, RoundingMode. HALF_UP)
                                   .movePointRight(2)
                                   .longValue();
        byte[] rep;
        try {
            BankMessage<K, V> request = new BankMessage<K, V>();
            request.setType(..........);

            // invokes BFT-SMaRt
            rep = this.serviceProxy.invokeOrdered(BankMessage.toBytes(request));
        } catch (IOException e) {
            System.out.println("Failed to  ..... " + e.getMessage());
            return null;
        }
        if (rep.length == 0) {
            return null;
        }

        try {
            BankMessage<K, V> response = BankMessage.fromBytes(rep);
            return XXXXXXXXXXXXXXXXXXX;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Failed to deserialized response of ....." + ex.getMessage());
            return null;
        }
    }

    public XXXX withdraw(int from, String amountStr) {
        java.math.BigDecimal value = new java.math.BigDecimal(amountStr);
        long initialBalance = value.setScale(2, RoundingMode. HALF_UP)
                                   .movePointRight(2)
                                   .longValue();
        byte[] rep;
        try {
            BankMessage<K, V> request = new BankMessage<K, V>();
            request.setType(..........);

            // invokes BFT-SMaRt
            rep = this.serviceProxy.invokeOrdered(BankMessage.toBytes(request));
        } catch (IOException e) {
            System.out.println("Failed to  ..... " + e.getMessage());
            return null;
        }
        if (rep.length == 0) {
            return null;
        }

        try {
            BankMessage<K, V> response = BankMessage.fromBytes(rep);
            return XXXXXXXXXXXXXXXXXXX;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Failed to deserialized response of ....." + ex.getMessage());
            return null;
        }
    }

    public XXXX transfer(int from, int to, String amountStr) {
        java.math.BigDecimal value = new java.math.BigDecimal(amountStr);
        long initialBalance = value.setScale(2, RoundingMode. HALF_UP)
                                   .movePointRight(2)
                                   .longValue();
        byte[] rep;
        try {
            BankMessage<K, V> request = new BankMessage<K, V>();
            request.setType(..........);

            // invokes BFT-SMaRt
            rep = this.serviceProxy.invokeOrdered(BankMessage.toBytes(request));
        } catch (IOException e) {
            System.out.println("Failed to  ..... " + e.getMessage());
            return null;
        }
        if (rep.length == 0) {
            return null;
        }

        try {
            BankMessage<K, V> response = BankMessage.fromBytes(rep);
            return XXXXXXXXXXXXXXXXXXX;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Failed to deserialized response of ....." + ex.getMessage());
            return null;
        }
    }

    public XXXX checkBalance(int from) {
        // ...
        rep = this.serviceProxy.invokeUnordered(BankMessage.toBytes(request));
        // ...
    }


}