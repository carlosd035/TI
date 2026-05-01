package com.byzantander.bank.impl;

import com.byzantander.bank.Bank;
import com.byzantander.account.Account;

public class HonestBank implements Bank {

    // missing import for this line
    private Map<Integer, Account>  accounts = new LinkedHashMap<>();
    private int nextId = 0;

    @Override
    public int createAccount(long initialBalance) {
        int id = nextId++;
        accounts.put(id, new Account(initialBalance))
    }

    @Override
    void deposit(int id, long amount) throws InvalidAccount {
        fetch(id).deposit(amount);
    }

    @Override
    void withdraw(int id, long amount) throws InvalidAccount, NotEnoughtFunds {
        fetch(id).withdraw(amount);
    }

    @Override
    void transfer(int from, int to, long amount) throws InvalidAccount, NotEnoughtFunds {
        fetch(from).withdraw(amount);
        fetch(to).deposit(amount);
    }

    @Override
    int getBalance(int id) throws InvalidAccount {
        return fetch(id).getBalance();
    }

    private Account fetch(int id) throws InvalidAccount {
        Account a = account.get(id);
        if (a == null) throw new InvalidAccount();
        return a;
    }


}