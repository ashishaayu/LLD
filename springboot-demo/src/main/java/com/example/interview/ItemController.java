package com.example.interview;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody CreateItemRequest request) {
        Item item = service.create(request);
        return ResponseEntity.created(URI.create("/api/items/" + item.id())).body(item);
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable UUID id) {
        return service.get(id);
    }
}
