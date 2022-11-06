package com.r4u.Reservation.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.r4u.security.models.Restaurant;
import com.r4u.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reservation {




	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	private User user;
	private Integer userid;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reservationDate;

	@DateTimeFormat(pattern = "hh-mm")
	private Time reservationTime;

	private Integer seats;

	@ManyToOne
	@JoinColumn(name="restaurantid", insertable = false, updatable = false)
	private Restaurant restaurant;
	private Integer restaurantid;
}
