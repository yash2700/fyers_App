package com.fyers.fyers.exceptions;

import com.fyers.fyers.enums.ExceptionConstants;

public class OtpNotFoundException extends RuntimeException{
    public OtpNotFoundException(ExceptionConstants exceptionConstants){
        super(exceptionConstants.toString());
    }
}
