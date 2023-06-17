package com.example.inventory.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory.entity.Item;
import com.example.inventory.entity.ItemCategory;
import com.example.inventory.respository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemCategoryService itemCategoryService;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item addItem(Item item,ItemCategory it){
        item.setItemCatergory(it);
        System.out.println(it.toString());
        System.out.println(item.toString());
         return itemRepository.save(item);
        
    }

    public Item findItem(long id){
        Optional<Item> item=itemRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        else{
            return new Item();
        }
    }

    public String deleteItem(long id){
        itemRepository.deleteById(id);
        return "item of id:"+id+" deleted Successfully";
    }

    public List<Item> findByCategory(String name){
        ItemCategory li=itemCategoryService.findByName(name);
        return itemRepository.findByItemCatergory(li);
    }
}
