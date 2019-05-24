package com.example.chapter1.exception;

public class MyException extends Exception {

    private static final long serialVersionUID = 998856042362652953L;

    public MyException(String message) {
        super(message);
    }
}
