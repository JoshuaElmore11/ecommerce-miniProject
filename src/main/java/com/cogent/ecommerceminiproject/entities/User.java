package com.cogent.ecommerceminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;

//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(
//            name = "users_orders",
//            joinColumns = @JoinColumn(
//                    name = "user_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "order_id",
//                    referencedColumnName = "id"
//            )
//    )
//    private Set<Order> orders;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;
}
