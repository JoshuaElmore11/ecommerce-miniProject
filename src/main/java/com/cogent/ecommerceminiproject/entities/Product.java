package com.cogent.ecommerceminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private String image;
    private double price;
    private boolean featured;
    private int position;
    private boolean status;

//    @ManyToMany(mappedBy = "products")
//    private Set<Order> orders;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Category category;

//    @ManyToOne(
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name = "subcategory_id",
//            nullable = false
//    )
//    private Subcategory subcategory;
}
