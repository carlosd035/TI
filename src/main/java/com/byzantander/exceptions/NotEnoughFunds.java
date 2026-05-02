package com.byzantine.exceptions;

public class NotEnoughFunds extends RuntimeException {

    public NotEnoughFunds(String exception) {
        super(exception);
    }
}