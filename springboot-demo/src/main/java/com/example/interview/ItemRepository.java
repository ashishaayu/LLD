package com.example.interview;

import java.util.Optional;
import java.util.UUID;

// Replace the implementation with a database adapter when needed.
public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(UUID id);
}
