package com.example.inventory.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.hibernate.annotations.GenerationTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    @OneToMany(mappedBy="itemCatergory",cascade=CascadeType.ALL)
    @Column(nullable=false)
    @JsonIgnore
    List<Item> items;
    public String toString(){
        return "["+id+","+categoryName+"]";
    }
}
