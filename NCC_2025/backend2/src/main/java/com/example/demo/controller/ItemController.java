package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

  
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);

        // Return 201 Created with Location header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{itemCode}")
                .buildAndExpand(savedItem.getItemCode())
                .toUri();

        return ResponseEntity.created(location).body(savedItem);
    }

 
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{itemCode}")
    public ResponseEntity<Item> getItemByCode(@PathVariable String itemCode) {
        return itemService.getItemByCode(itemCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @PutMapping("/{itemCode}")
    public ResponseEntity<Item> updateItem(@PathVariable String itemCode, @RequestBody Item itemDetails) {
        return itemService.getItemByCode(itemCode)
                .map(existingItem -> {
                 
                    existingItem.setUnitPrice(itemDetails.getUnitPrice());
                    existingItem.setUpdatedDate(itemDetails.getUpdatedDate());

                    Item updatedItem = itemService.saveItem(existingItem);
                    return ResponseEntity.ok(updatedItem);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable String itemCode) {
        return itemService.getItemByCode(itemCode)
                .map(item -> {
                    itemService.deleteItemByCode(itemCode);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
