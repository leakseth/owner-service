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
        OwnerRegisterRequest newRequest = new OwnerRegisterRequest();
        newRequest.setEmail(emailNormalizer.normalize(request.getEmail()));
        newRequest.setPhone(phoneNormalizer.normalize(request.getPhone()));
        return newRequest;
    }
}
