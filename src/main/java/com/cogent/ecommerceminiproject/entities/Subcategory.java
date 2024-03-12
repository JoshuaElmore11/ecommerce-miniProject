package com.cogent.ecommerceminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subcategory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private boolean status;
    private boolean featured;
    private int position;

    @OneToMany(
            mappedBy = "subcategory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Product> products = new HashSet<>();

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Category category;
}
