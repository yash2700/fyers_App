package com.fyers.fyers.controller;

import com.fyers.fyers.dto.LoginRequestDto;
import com.fyers.fyers.dto.RefreshTokenDto;
import com.fyers.fyers.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("/getAccessToken")
    public ResponseEntity<String> getAccessToken(@RequestParam("appId") String appId){
        return new ResponseEntity<>(loginService.getAccessToken(appId), HttpStatus.OK);
    }

    @PostMapping("/newToken")
    public ResponseEntity<String> generateNewAccessToken(@RequestBody()LoginRequestDto loginRequestDto) throws InterruptedException {
        return new ResponseEntity<>(loginService.getNewAccessToken(loginRequestDto),HttpStatus.OK);
    }

    @PostMapping("/newTokenRefresh")
    public ResponseEntity<String> generateNewTokenUsingRefreshToken(@RequestBody() RefreshTokenDto refreshTokenDto){
        return new ResponseEntity<>(loginService.generateAccessTokenUsingRefreshToken(refreshTokenDto),HttpStatus.OK);
    }





}
