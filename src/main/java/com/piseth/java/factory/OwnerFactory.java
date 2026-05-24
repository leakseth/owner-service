package com.piseth.java.factory;

import com.piseth.java.domain.Owner;
import com.piseth.java.domain.enums.OwnerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class OwnerFactory {
    private final Clock clock;

    public Owner newPendingOwner(Owner draft){
        Instant now = Instant.now(clock);

        return Owner.builder()
                .id(draft.getId())
                .email(draft.getEmail())
                .phone(draft.getPhone())
                .status(OwnerStatus.PENDING)
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
