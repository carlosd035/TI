package com.byzantander.bank.impl;

import com.byzantander.bank.Bank;
import com.byzantander.account.Account;

import com.byzantander.exceptions.InvalidAccount;
import com.byzantander.exceptions.NotEnoughtFunds;

public class MaliciousBank implements Bank {

    private Map<Integer, Account>  accounts = new LinkedHashMap<>();

    @Override
    public int createAccount(int id, long initialBalance) {
        accounts.put(id, new Account(initialBalance));
    }

    @Override
    void deposit(int id, long amount) throws InvalidAccount {
        // can add an attack here if we want or keep the same as HonestBank
    }

    // i will add an attack example here
    @Override
    void withdraw(int id, long amount) throws InvalidAccount, NotEnoughtFunds {
        fetch(id).forceWithdraw(amount);
    }

    @Override
    void transfer(int from, int to, long amount) throws InvalidAccount, NotEnoughtFunds {
        // can add an attack here if we want or keep the same as HonestBank
    }

    @Override
    int getBalance(int id) throws InvalidAccount {
        // can add an attack here if we want or keep the same as HonestBank
    }

    private Account fetch(int id) throws InvalidAccount {
        Account a = account.get(id);
        if (a == null) throw new InvalidAccount();
        return a;
    }


}