package com.fyers.fyers.controller;

import com.fyers.fyers.request.QuoteRequest;
import com.fyers.fyers.response.quote.QuoteResponse;
import com.fyers.fyers.serviceImpl.QuoteServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/quote")
@Validated
public class QuoteController {
    final QuoteServiceImpl service;

    public QuoteController(QuoteServiceImpl service){
        this.service=service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<QuoteResponse> getQuotes(@Valid @RequestBody()QuoteRequest quoteRequest,
                                                   @RequestParam("appId")   @NotBlank( message = "Please check the input! Try Again!")  String appId){
        return new ResponseEntity<>(service.getQuote(quoteRequest.getList(),appId), HttpStatus.OK);
    }
}
