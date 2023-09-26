package com.fyers.fyers.exceptions;

import com.fyers.fyers.enums.ExceptionConstants;

public class AccessTokenNotFoundException extends RuntimeException{
    public AccessTokenNotFoundException(ExceptionConstants exceptionConstants){
        super(exceptionConstants.toString());
    }
}
