package com.r4u.security.models;

import com.r4u.Reservation.models.Reservation;
import com.r4u.parameters.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * This is the User Model her you can see
 * which attributes a User has
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"User\"") // without this you can not save a user in a Postgresql Database because it is a spezial Tablename
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    /**
     * Many User to Many Roles
     */
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

    /**
     * 1 User to Many Reservations
     */
    @OneToMany(mappedBy="user")
    private List<Reservation> reservation; //reservations

}
