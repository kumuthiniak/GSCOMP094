package com.example.demo.controller;

import com.example.demo.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ItemRepository;
;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/itemNew")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }
}
