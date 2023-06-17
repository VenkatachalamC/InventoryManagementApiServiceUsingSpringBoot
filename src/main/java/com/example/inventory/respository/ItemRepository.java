package com.example.inventory.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.entity.Item;
import com.example.inventory.entity.ItemCategory;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    public List<Item> findByItemCatergory(ItemCategory it);
}
