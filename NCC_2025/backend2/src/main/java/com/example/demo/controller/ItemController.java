package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:8080")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try {
            // If updatedDate is not provided, set it to current date
            if (item.getUpdatedDate() == null) {
                item.setUpdatedDate(LocalDate.now());
            }
            
            Item savedItem = itemRepository.save(item);
            return ResponseEntity.ok(savedItem);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating item: " + e.getMessage());
        }
    }

    @GetMapping("/{itemCode}")
    public ResponseEntity<Item> getItemById(@PathVariable String itemCode) {
        Optional<Item> item = itemRepository.findById(itemCode);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{itemCode}")
    public ResponseEntity<Item> updateItem(@PathVariable String itemCode, @RequestBody Item itemDetails) {
        Optional<Item> optionalItem = itemRepository.findById(itemCode);
        
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setItemName(itemDetails.getItemName());
            item.setUnitPrice(itemDetails.getUnitPrice());
            item.setUpdatedDate(LocalDate.now()); // Always update the date on modification
            
            Item updatedItem = itemRepository.save(item);
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<?> deleteItem(@PathVariable String itemCode) {
        if (itemRepository.existsById(itemCode)) {
            itemRepository.deleteById(itemCode);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}