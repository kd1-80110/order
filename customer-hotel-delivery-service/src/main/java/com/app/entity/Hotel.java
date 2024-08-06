package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "hotel_details")
public class Hotel {

	@Id
	@Column(name = "hotel_id", length = 10)
	private String hotelId;

	@Column(name = "hotel_name", length = 20)
	private String hotelName;

	@Column(name = "hotel_type", length = 20)
	private String hotelType;

	@Column(name = "rating")
	private Integer rating;
}
