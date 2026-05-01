package com.byzantander.account;

import java.io.Serializable;

class Account implements Serializable {
    private long balance;

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }

    // Honest method
    public void withdraw(long amount) throws NotEnoughtFunds {
        if (this.balance < amount) {
            throw new NotEnoughtFunds("Balance too low: " + this.balance)
        }
        this.balance -=amount;
    }

    // Malicious method (Example for attack)
    public void forceWithdraw(long amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }

}