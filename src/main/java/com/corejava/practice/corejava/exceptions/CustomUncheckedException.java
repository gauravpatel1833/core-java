package com.corejava.practice.corejava.exceptions;

public class CustomUncheckedException extends RuntimeException{

    public CustomUncheckedException(String errorMessage){
        super(errorMessage);
    }
}
