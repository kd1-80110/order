package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.DeliveryPartner;

public interface DeliveryPartnerDao extends JpaRepository<DeliveryPartner, String> {

}
