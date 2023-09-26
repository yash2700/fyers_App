package com.fyers.fyers.dto;

import com.fyers.fyers.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileDto {
    public String name;
    public String display_name;
    public String fy_id;
    public String image;
    public String email_id;
    public String pan;
    public String pin_change_date;
    public String pwd_change_date;
    public String mobile_number;
    public boolean totp;
    public int pwd_to_expire;

    public static ProfileDto generateDto(Profile profile){
        return ProfileDto.builder()
                .name(profile.getName())
                .display_name(profile.getDisplayName())
                .fy_id(profile.getFyId())
                .image(profile.getImage())
                .email_id(profile.getEmailId())
                .pan(profile.getPAN())
                .pin_change_date(profile.getPinChangeDate())
                .pwd_change_date(profile.getPwdChangeDate())
                .mobile_number(profile.getMobileNumber())
                .totp(profile.isTotp())
                .pwd_to_expire(profile.getPwdToExpire())
                .build();
    }
}
