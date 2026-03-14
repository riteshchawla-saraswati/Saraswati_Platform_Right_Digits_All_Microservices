package com.right.digits.platform.kafka.producer.microservice.services.impl;

import com.right.digits.platform.kafka.producer.microservice.entities.RightDigitsUserEntity;
import com.right.digits.platform.kafka.producer.microservice.exception.DuplicateEmailException;
import com.right.digits.platform.kafka.producer.microservice.exception.ResourceNotFoundException;
import com.right.digits.platform.kafka.producer.microservice.helpers.RightDigitsEmailSanitizer;
import com.right.digits.platform.kafka.producer.microservice.repository.RightDigitsUserRepository;
import com.right.digits.platform.kafka.producer.microservice.request.RightDigitsUserRequestDTO;
import com.right.digits.platform.kafka.producer.microservice.response.RightDigitsUserResponse;
import com.right.digits.platform.kafka.producer.microservice.services.IRightDigitsUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RightDigitsUserServiceImpl implements IRightDigitsUserService {

    private final RightDigitsUserRepository userRepository;
    private final RightDigitsEmailSanitizer emailSanitizer; // custom Spring bean

    @Override
    public RightDigitsUserResponse create(RightDigitsUserRequestDTO request) {
        String email = emailSanitizer.sanitize(request.email());
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException("Email already in use: " + email);
        }
        RightDigitsUserEntity rightDigitsUserEntity = RightDigitsUserEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(email)
                .phone(request.phone())
                .build();
        return toResponse(userRepository.save(rightDigitsUserEntity));
    }

    @Override
    public RightDigitsUserResponse getById(Long id) {
        RightDigitsUserEntity rightDigitsUserEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RightDigitsUser not found: id=" + id));
        return toResponse(rightDigitsUserEntity);
    }

    @Override
    public Page<RightDigitsUserResponse> list(String search, Pageable pageable) {
        if (search == null || search.isBlank()) {
            return userRepository.findAll(pageable).map(this::toResponse);
        }
        return userRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        search, search, search, pageable
                ).map(this::toResponse);
    }

    @Override
    public RightDigitsUserResponse update(Long id, RightDigitsUserRequestDTO request) {
        RightDigitsUserEntity rightDigitsUserEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RightDigitsUser not found: id=" + id));

        String newEmail = emailSanitizer.sanitize(request.email());
        if (!rightDigitsUserEntity.getEmail().equalsIgnoreCase(newEmail) && userRepository.existsByEmail(newEmail)) {
            throw new DuplicateEmailException("Email already in use: " + newEmail);
        }

        rightDigitsUserEntity.setFirstName(request.firstName());
        rightDigitsUserEntity.setLastName(request.lastName());
        rightDigitsUserEntity.setEmail(newEmail);
        rightDigitsUserEntity.setPhone(request.phone());

        return toResponse(userRepository.save(rightDigitsUserEntity));
    }

    @Override
    public RightDigitsUserResponse patch(Long id, RightDigitsUserRequestDTO request) {
        RightDigitsUserEntity rightDigitsUserEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RightDigitsUser not found: id=" + id));

        if (request.firstName() != null && !request.firstName().isBlank()) {
            rightDigitsUserEntity.setFirstName(request.firstName());
        }
        if (request.lastName() != null && !request.lastName().isBlank()) {
            rightDigitsUserEntity.setLastName(request.lastName());
        }
        if (request.email() != null && !request.email().isBlank()) {
            String newEmail = emailSanitizer.sanitize(request.email());
            if (!rightDigitsUserEntity.getEmail().equalsIgnoreCase(newEmail) && userRepository.existsByEmail(newEmail)) {
                throw new DuplicateEmailException("Email already in use: " + newEmail);
            }
            rightDigitsUserEntity.setEmail(newEmail);
        }
        if (request.phone() != null) {
            rightDigitsUserEntity.setPhone(request.phone());
        }
        return toResponse(userRepository.save(rightDigitsUserEntity));
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("RightDigitsUser not found: id=" + id);
        }
        userRepository.deleteById(id);
    }

    private RightDigitsUserResponse toResponse(RightDigitsUserEntity u) {
        return new RightDigitsUserResponse(
                u.getId(),
                u.getFirstName(),
                u.getLastName(),
                u.getEmail(),
                u.getPhone(),
                u.getCreatedAt(),
                u.getUpdatedAt()
        );
    }
}
