package com.clone.CloneFlipCart.Service;

import com.clone.CloneFlipCart.Exception.ItemNotFoundException;
import com.clone.CloneFlipCart.Model.Item;
import com.clone.CloneFlipCart.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.fetchAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
    }

    public boolean updateItem(Long id, Item updatedItem) {
        return itemRepository.updateById(id, updatedItem);
    }

    public Boolean deleteById(Long id){
        return itemRepository.deleteById(id);
    }


}
