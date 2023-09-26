package com.fyers.fyers.Service;

import com.fyers.fyers.dto.LoginRequestDto;
import com.fyers.fyers.dto.RefreshTokenDto;

public interface LoginService {
    String getAccessToken(String clientId);
    String getNewAccessToken(LoginRequestDto loginRequestDto) throws InterruptedException;

    String generateAccessTokenUsingRefreshToken(RefreshTokenDto refreshTokenDto);
}
