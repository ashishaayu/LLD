package com.example.interview;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record AlterRequest(
        @NotBlank String serviceId,
        @NotNull Severity severity,
        @NotBlank String title,
        String description,
        @NotBlank String dedupekey,
        Instant timeStamp
) {
}
