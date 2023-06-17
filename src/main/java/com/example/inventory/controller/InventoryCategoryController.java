package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entity.ItemCategory;
import com.example.inventory.service.ItemCategoryService;

@RestController
public class InventoryCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public List<ItemCategory> findAllCategory(){
        return itemCategoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public ItemCategory findCategory(@PathVariable long id){
        return itemCategoryService.findByid(id);
    }

    @PostMapping("/category")
    public ItemCategory addCategory(ItemCategory it){
        return itemCategoryService.saveCategory(it);
    }

    @DeleteMapping("/itemCategory/{id}")
    public String deleteCategory(@PathVariable long id){
        ItemCategory it=itemCategoryService.findByid(id);
        return itemCategoryService.deleteCategory(it);
    }
    
}
