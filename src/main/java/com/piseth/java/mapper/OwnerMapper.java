package com.piseth.java.mapper;

import com.piseth.java.domain.Owner;
import com.piseth.java.dto.OwnerRegisterRequest;
import com.piseth.java.dto.OwnerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Owner toOwnerDraft(OwnerRegisterRequest request);

    OwnerResponse toResponse(Owner owner);
}
