package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entity.Item;
import com.example.inventory.entity.ItemCategory;
import com.example.inventory.service.ItemCategoryService;
import com.example.inventory.service.ItemService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class InventoryController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCategoryService itemCategoryService;
    @GetMapping("/items")
    public List<Item> getItems(){
        return itemService.getItems();
    }
    //look after review
    @PostMapping("/item/{category}")
    public Item addItem(Item item,@PathVariable String category){
        System.out.println(category);
        System.out.println(item.getName()+""+item.getPrice());
        ItemCategory it=itemCategoryService.findByName(category);
        System.out.println(it.getCategoryName());
        return itemService.addItem(item,it);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable long id){
        return itemService.findItem(id);
    }

    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable long id){
        return itemService.deleteItem(id);
    }

}
