package com.clone.CloneFlipCart.Controller;

import com.clone.CloneFlipCart.Model.Item;
import com.clone.CloneFlipCart.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Add new item
    @PostMapping
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully");
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    //Get all items
    @GetMapping
    public ResponseEntity<?> getAllItems() {
        List<Item> items = itemService.getItems();
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }

    //Update item by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @Valid @RequestBody Item item) {
        boolean updated = itemService.updateItem(id, item);
        if (updated) {
            return ResponseEntity.status(HttpStatus.OK).body("Item updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }

    //Delete item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        boolean deleted = itemService.deleteById(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Item deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }

}
