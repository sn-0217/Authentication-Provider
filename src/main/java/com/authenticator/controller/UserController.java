package com.authenticator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authenticator.dto.AppUserRequestDto;
import com.authenticator.dto.AppUserResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.authenticator.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping
    public AppUserResponseDto register(@Valid @RequestBody AppUserRequestDto dto){
        return userService.save(dto);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<AppUserResponseDto> getByName(@PathVariable String userName){
        System.out.println("test");
        return new ResponseEntity<>(userService.getByName(userName), HttpStatus.OK);
    }
}
