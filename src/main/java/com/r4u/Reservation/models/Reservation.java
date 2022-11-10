package com.r4u.Reservation.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.r4u.Restaurant.models.Restaurant;
import com.r4u.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.security.Principal;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reservation {





	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reservationDate;
	private String reservationTime;
	private Integer seats;

	@ManyToOne
	@JoinColumn(name="restaurantid", insertable = false, updatable = false)
	private Restaurant restaurant;
	private Integer restaurantid;


	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	private User user;
	private Integer userid;




}
