package com.authenticator.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authenticator.dto.AppUserRequestDto;
import com.authenticator.dto.AppUserResponseDto;
import com.authenticator.entity.AppUser;
import com.authenticator.mapper.AppUserMapper;

import lombok.RequiredArgsConstructor;
import com.authenticator.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserResponseDto save(AppUserRequestDto appUserRequestDto){
        AppUser appUser = AppUserMapper.toEntity(appUserRequestDto);

        appUser = appUser.toBuilder()
                         .password(passwordEncoder.encode(appUser.getPassword()))
                         .build();
        AppUser savedUser = userRepository.save(appUser);
        return AppUserMapper.toDto(savedUser);
    }

    public AppUserResponseDto getByName(String userName){
        return AppUserMapper.toDto(userRepository.findAppUserByUserName(userName).get());
    }
}
