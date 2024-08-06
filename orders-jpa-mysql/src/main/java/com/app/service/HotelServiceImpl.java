package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.HotelDao;
import com.app.dto.HotelDto;
import com.app.entity.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao hotelDao;

	@Override
	public List<HotelDto> getAllHotels() {
		return hotelDao.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public HotelDto getHotelById(String hotelId) {
		return convertToDto(hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found")));
	}

	@Override
	public HotelDto createHotel(HotelDto hotelDto) {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotelDto, hotel);
		return convertToDto(hotelDao.save(hotel));
	}

	@Override
	public HotelDto updateHotel(String hotelId, HotelDto hotelDto) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
		BeanUtils.copyProperties(hotelDto, hotel);
		return convertToDto(hotelDao.save(hotel));
	}

	@Override
	public void deleteHotel(String hotelId) {
		hotelDao.deleteById(hotelId);
	}

	private HotelDto convertToDto(Hotel hotel) {
		HotelDto hotelDto = new HotelDto();
		BeanUtils.copyProperties(hotel, hotelDto);
		return hotelDto;
	}

}
