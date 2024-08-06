package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_partners")
public class DeliveryPartner {

	@Id
	@Column(name = "partner_id", length = 10)
	private String partnerId;

	@Column(name = "partner_name", length = 20)
	private String partnerName;

	@Column(name = "phone_no")
	private Long phoneNo;

	@Column(name = "rating")
	private Integer rating;
}
