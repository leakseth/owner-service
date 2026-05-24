package com.piseth.java.controller;

import com.piseth.java.dto.OwnerRegisterRequest;
import com.piseth.java.dto.OwnerResponse;
import com.piseth.java.service.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OwnerResponse> register(@Valid @RequestBody OwnerRegisterRequest request){
        return ownerService.register(request);
    }
}
