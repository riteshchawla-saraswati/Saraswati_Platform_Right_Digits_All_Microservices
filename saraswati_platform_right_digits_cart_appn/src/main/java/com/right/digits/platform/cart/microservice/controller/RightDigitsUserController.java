package com.right.digits.platform.cart.microservice.controller;

import com.right.digits.platform.cart.microservice.request.RightDigitsUserRequestDTO;
import com.right.digits.platform.cart.microservice.response.RightDigitsUserResponse;
import com.right.digits.platform.cart.microservice.services.IRightDigitsUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class RightDigitsUserController {

    private final IRightDigitsUserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RightDigitsUserResponse create(@Valid @RequestBody RightDigitsUserRequestDTO request) {
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public RightDigitsUserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<RightDigitsUserResponse> list(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 20, sort = "lastName") Pageable pageable
    ) {
        return userService.list(search, pageable);
    }

    @PutMapping("/{id}")
    public RightDigitsUserResponse update(@PathVariable Long id, @Valid @RequestBody RightDigitsUserRequestDTO request) {
        return userService.update(id, request);
    }

    @PatchMapping("/{id}")
    public RightDigitsUserResponse patch(@PathVariable Long id, @RequestBody RightDigitsUserRequestDTO request) {
        // Partial update (validation handled in service)
        return userService.patch(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
