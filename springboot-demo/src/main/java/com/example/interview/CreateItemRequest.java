package com.example.interview;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateItemRequest(@NotBlank @Size(max = 200) String name) {}
