package com.piseth.java.dto;

import com.piseth.java.domain.enums.OwnerStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
public class OwnerResponse {
    private UUID id;
    private String email;
    private String phone;
    private OwnerStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
