package com.app.service;

import java.util.List;

import com.app.dto.HotelDto;

public interface HotelService {

	List<HotelDto> getAllHotels();

	HotelDto getHotelById(String hotelId);

	HotelDto createHotel(HotelDto hotelDto);

	HotelDto updateHotel(String hotelId, HotelDto hotelDto);

	void deleteHotel(String hotelId);

}
