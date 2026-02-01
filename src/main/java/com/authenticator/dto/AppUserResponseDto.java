package com.authenticator.dto;

import java.time.Instant;

public record AppUserResponseDto(
    String username,
    String email,
    Instant modifiedAt
) {}