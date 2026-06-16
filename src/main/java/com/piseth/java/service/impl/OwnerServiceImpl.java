package com.piseth.java.service.impl;

import com.piseth.java.domain.Owner;
import com.piseth.java.dto.OwnerRegisterRequest;
import com.piseth.java.dto.OwnerResponse;
import com.piseth.java.factory.OwnerFactory;
import com.piseth.java.mapper.OwnerMapper;
import com.piseth.java.normolizer.OwnerRegisterRequestNormalizer;
import com.piseth.java.repository.OwnerRepository;
import com.piseth.java.service.OwnerService;
import com.piseth.java.validation.OwnerRegistrationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final OwnerFactory ownerFactory;
    private final OwnerRegistrationValidator registrationValidator;
    private final OwnerRegisterRequestNormalizer normalizer;

    @Override
    public Mono<OwnerResponse> register(OwnerRegisterRequest request) {
        OwnerRegisterRequest normalized = normalizer.normalize(request);

        Owner draft = ownerMapper.toOwnerDraft(normalized);
        Owner pending = ownerFactory.newPendingOwner(draft);

        return registrationValidator.validate(normalized)
                .then(ownerRepository.save(pending))
                .doOnSuccess(saved2 -> log.info("Owner registered successfully. ownerId={}", saved2))
                .map(ownerMapper::toResponse);
    }
}
