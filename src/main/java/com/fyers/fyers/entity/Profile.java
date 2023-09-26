package com.fyers.fyers.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    @JsonProperty("fy_id")
    private String fyId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("pin_change_date")
    private String pinChangeDate;
    @JsonProperty("email_id")
    private String emailId;
    @JsonProperty("pwd_change_date")
    private String pwdChangeDate;
    @JsonProperty("PAN")
    private String PAN;
    @JsonProperty("mobile_number")
    private String mobileNumber;
    @JsonProperty("totp")
    private boolean totp;
    @JsonProperty("pwd_to_expire")
    private int pwdToExpire;
}
