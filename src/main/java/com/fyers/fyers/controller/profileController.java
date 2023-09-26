package com.fyers.fyers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.dto.FundsDto;
import com.fyers.fyers.dto.ProfileDto;
import com.fyers.fyers.response.HoldingsResponse;
import com.fyers.fyers.serviceImpl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class profileController {

    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/getProfile")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam("appId")String appId) throws JsonProcessingException {
        return new ResponseEntity<>(profileService.getProfile(appId), HttpStatus.OK);
    }

    @GetMapping("/getFunds")
    public ResponseEntity<List<FundsDto>> getFunds(@RequestParam("appId") String appId) throws JsonProcessingException {
            return new ResponseEntity<>(profileService.getFunds(appId),HttpStatus.OK);
    }

    @GetMapping("/getHoldings")
    public ResponseEntity<HoldingsResponse> getHoldings(@RequestParam("appId")String appId) throws JsonProcessingException {
        return new ResponseEntity<>(profileService.getHoldings(appId),HttpStatus.OK);
    }
}
