package com.piseth.java.domain;

import com.piseth.java.domain.enums.OwnerStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("owners")
public class Owner {
    @Id
    private UUID id;
    private String email;
    private String phone;
    private OwnerStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
