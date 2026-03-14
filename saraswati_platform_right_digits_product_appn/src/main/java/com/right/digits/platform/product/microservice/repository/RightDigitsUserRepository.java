package com.right.digits.platform.product.microservice.repository;


import com.right.digits.platform.product.microservice.entities.RightDigitsUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RightDigitsUserRepository extends JpaRepository<RightDigitsUserEntity, Long> {
    boolean existsByEmail(String email);
    Optional<RightDigitsUserEntity> findByEmail(String email);

    Page<RightDigitsUserEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstName, String lastName, String email, Pageable pageable
    );
}
