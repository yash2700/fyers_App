package com.fyers.fyers.exceptions;

import com.fyers.fyers.enums.ExceptionConstants;

public class GenericException extends RuntimeException{
    public GenericException(ExceptionConstants e){
        super(e.toString());
    }
}
