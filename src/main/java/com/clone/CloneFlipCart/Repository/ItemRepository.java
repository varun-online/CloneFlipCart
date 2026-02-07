package com.clone.CloneFlipCart.Repository;

import com.clone.CloneFlipCart.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    private final List<Item> items = new ArrayList<>();
    private Long idCounter = 1L;

    public Item save(Item item) {
        item.setId(idCounter++);
        items.add(item);
        return item;
    }

    public List<Item> fetchAll(){
        return items;
    }

    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public boolean updateById(Long id, Item updatedItem) {

        for (Item item : items) {
            if (item.getId().equals(id)) {
                item.setName(updatedItem.getName());
                item.setCategory(updatedItem.getCategory());
                item.setPrice(updatedItem.getPrice());
                item.setDescription(updatedItem.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }

}
