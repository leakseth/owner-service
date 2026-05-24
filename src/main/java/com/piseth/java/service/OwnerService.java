package com.piseth.java.service;

import com.piseth.java.dto.OwnerRegisterRequest;
import com.piseth.java.dto.OwnerResponse;
import reactor.core.publisher.Mono;

public interface OwnerService {
    Mono<OwnerResponse> register(OwnerRegisterRequest request);
}
