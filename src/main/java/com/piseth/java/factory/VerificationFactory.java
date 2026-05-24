package com.piseth.java.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
@RequiredArgsConstructor
public class VerificationFactory {
    private final Clock clock;
}
