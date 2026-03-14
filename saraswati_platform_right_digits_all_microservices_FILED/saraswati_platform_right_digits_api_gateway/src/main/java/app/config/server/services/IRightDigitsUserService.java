package app.config.server.services;

import app.config.server.request.RightDigitsUserRequestDTO;
import app.config.server.response.RightDigitsUserResponse;
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
