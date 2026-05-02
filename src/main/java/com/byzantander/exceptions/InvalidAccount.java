package com.byzantine.exceptions;

public class InvalidAccount extends RuntimeException {

    public InvalidAccount(String exception) {
        super(exception);
    }
}