package com.example.interview;

import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryItemRepository implements ItemRepository {
    private final ConcurrentMap<UUID, Item> items = new ConcurrentHashMap<>();

    @Override
    public Item save(Item item) {
        items.put(item.id(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(UUID id) {
        return Optional.ofNullable(items.get(id));
    }
}
