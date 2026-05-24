package com.piseth.java.normolizer;

import com.piseth.java.dto.OwnerRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerRegisterRequestNormalizer {
    private final EmailNormalizer emailNormalizer;
    private final PhoneNormalizer phoneNormalizer;

    public OwnerRegisterRequest normalize(OwnerRegisterRequest request){
        request.setEmail(emailNormalizer.normalize(request.getEmail()));
        request.setPhone(phoneNormalizer.normalize(request.getPhone()));
        return request;
    }
}
