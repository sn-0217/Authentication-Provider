package com.authenticator.mapper;


import com.authenticator.dto.AppUserRequestDto;
import com.authenticator.dto.AppUserResponseDto;
import com.authenticator.entity.AppUser;

public class AppUserMapper {


    public static AppUser toEntity(AppUserRequestDto appUserRequestDto) {
        return AppUser.builder().userName(appUserRequestDto.userName())
                .password(appUserRequestDto.password())
                .email(appUserRequestDto.email())
                .build();
    }

    public static AppUserResponseDto toDto(AppUser appUser){
        return new AppUserResponseDto(
            appUser.getUserName(), 
            appUser.getEmail(), 
            appUser.getModifiedAt()
        );
    }
}
