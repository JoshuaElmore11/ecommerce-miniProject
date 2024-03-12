package com.cogent.ecommerceminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="addresses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    private int streetNumber;
    private String street;
    private String city;
    private String state;
    private int zipcode;

    @OneToOne(mappedBy = "address")
    private User user;
}
