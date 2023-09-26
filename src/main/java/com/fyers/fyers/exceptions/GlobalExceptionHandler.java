package com.fyers.fyers.exceptions;

import com.fyers.fyers.error.ErrorInfo;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@PropertySource("classpath:messages.properties")
public class GlobalExceptionHandler {
    @Autowired
    Environment environment;
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({AccessTokenNotFoundException.class, OtpNotFoundException.class, RefreshTokenNotFound.class,GenericException.class})
    public ResponseEntity<ErrorInfo> handleExceptions(Exception e){
        logger.error(environment.getProperty(e.getMessage()));
        return new ResponseEntity<>(
                ErrorInfo.builder()
                        .error(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .message(environment.getProperty(e.getMessage()))
                        .statusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handleValidationErrors(MethodArgumentNotValidException e){
        logger.error(environment.getProperty(e.getMessage()));
        List<String> errors=e.getBindingResult().getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return new ResponseEntity<>( ErrorInfo.builder()
                .error(HttpStatus.BAD_REQUEST.toString())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .message(errors.toString())
                .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorInfo> handleValidation(ValidationException e){
        return new ResponseEntity<>(ErrorInfo.builder()
                .message(e.getMessage())
                .error(HttpStatus.BAD_REQUEST.toString())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .build()
        ,HttpStatus.BAD_REQUEST);
    }

}
