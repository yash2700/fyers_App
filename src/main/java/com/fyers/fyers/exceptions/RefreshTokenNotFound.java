package com.fyers.fyers.exceptions;

import com.fyers.fyers.enums.ExceptionConstants;

public class RefreshTokenNotFound extends RuntimeException{
    public RefreshTokenNotFound(ExceptionConstants exceptionConstants){
        super(exceptionConstants.toString());
    }
}
