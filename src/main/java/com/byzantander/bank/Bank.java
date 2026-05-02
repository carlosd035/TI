package com.byzantander.bank;

import java.io.Serializable;

import com.byzantander.exceptions.InvalidAccount;
import com.byzantander.exceptions.NotEnoughtFunds;

public interface Bank implements Serializable {
    int createAccount(long initialBalance);
    void deposit(int id, long amount) throws InvalidAccount;
    void withdraw(int id, long amount) throws InvalidAccount, NotEnoughtFunds;
    void transfer(int from, int to, long amount) throws InvalidAccount, NotEnoughtFunds;
    int getBalance(int id) throws InvalidAccount;
}