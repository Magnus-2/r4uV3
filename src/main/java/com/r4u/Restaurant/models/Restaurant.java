package com.r4u.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Restaurant {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	private String name;
	private Integer seats;
	private Integer zipcode;
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


	@ManyToOne
	@JoinColumn(name="reservationtid", insertable = false, updatable = false)
	private com.r4u.Reservation.models.Reservation reservation;
	private Integer reservationid;
}
