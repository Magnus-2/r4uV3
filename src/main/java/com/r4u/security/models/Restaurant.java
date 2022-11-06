package com.r4u.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"Restaurant\"")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String username;
    private String name;
    private String seats;
    private String zipcode;
    private String address;
    private String category;
    private String ohmo;
    private String ohtu;
    private String ohwe;
    private String ohth;
    private String ohfr;
    private String ohsa;
    private String ohsu;
    private String phonenumber;
    private String email;
    private String password;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Restaurant_role",
            joinColumns = {@JoinColumn(name = "Restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

}
