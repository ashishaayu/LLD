package com.example.interview;

import java.time.Instant;
import java.util.UUID;

public record Item(UUID id, String name, Instant createdAt) {}
