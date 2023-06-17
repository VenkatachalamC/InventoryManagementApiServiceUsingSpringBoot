package com.example.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.ItemCategory;
import com.example.inventory.respository.ItemCategoryRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryService {
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;
    public List<ItemCategory> getAllCategory(){
        List<ItemCategory>it=itemCategoryRepository.findAll();
        return it;
    }

    public ItemCategory findByid(long id){
        Optional<ItemCategory> it=itemCategoryRepository.findById(id);
        if(it.isPresent()){
            return it.get();
        }
        else{
            return new ItemCategory();
        }
    }

    public ItemCategory saveCategory(ItemCategory it){
        return itemCategoryRepository.save(it);
    }
    public ItemCategory findByName(String name){
        return itemCategoryRepository.findByCategoryName(name);
    }
    public String deleteCategory(ItemCategory it){
        itemCategoryRepository.delete(it);
        return "delete successful";
    }
}
