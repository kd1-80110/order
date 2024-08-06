package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HotelDto;
import com.app.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public List<HotelDto> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public HotelDto getHotelById(@PathVariable("id") String hotelId) {
		return hotelService.getHotelById(hotelId);
	}

	@PostMapping
	public HotelDto createHotel(@RequestBody HotelDto hotelDto) {
		return hotelService.createHotel(hotelDto);
	}

	@PutMapping("/{id}")
	public HotelDto updateHotel(@PathVariable("id") String hotelId, @RequestBody HotelDto hotelDto) {
		return hotelService.updateHotel(hotelId, hotelDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable("id") String hotelId) {
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.noContent().build();
	}

}
