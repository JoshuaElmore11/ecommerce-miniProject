package com.cogent.ecommerceminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

//@Entity
//@Table(name="orders")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class Order {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
//    private long id;
//    private Date date;
//
//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(
//            name = "orders_products",
//            joinColumns = @JoinColumn(
//                    name = "order_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "product_id",
//                    referencedColumnName = "id"
//            )
//    )
//    private Set<Product> products;
//
//    @ManyToMany(mappedBy = "orders")
//    private Set<User> users;
}
