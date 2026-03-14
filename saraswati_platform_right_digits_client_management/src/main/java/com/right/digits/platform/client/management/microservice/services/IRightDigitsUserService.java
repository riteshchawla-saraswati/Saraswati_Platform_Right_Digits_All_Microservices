package com.right.digits.platform.api.gateway.microservice.services;

import com.right.digits.platform.api.gateway.microservice.request.RightDigitsUserRequestDTO;
import com.right.digits.platform.api.gateway.microservice.response.RightDigitsUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRightDigitsUserService {
    RightDigitsUserResponse create(RightDigitsUserRequestDTO request);
    RightDigitsUserResponse getById(Long id);
    Page<RightDigitsUserResponse> list(String search, Pageable pageable);
    RightDigitsUserResponse update(Long id, RightDigitsUserRequestDTO request);
    RightDigitsUserResponse patch(Long id, RightDigitsUserRequestDTO request);
    void delete(Long id);
}
