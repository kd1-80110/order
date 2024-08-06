package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, String> {

}
