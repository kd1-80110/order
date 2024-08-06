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

import com.app.dto.DeliveryPartnerDto;
import com.app.service.DeliveryPartnerService;

@RestController
@RequestMapping("/api/partners")
public class DeliveryPartnerController {

	@Autowired
	private DeliveryPartnerService partnerService;

	@GetMapping
	public List<DeliveryPartnerDto> getAllPartners() {
		return partnerService.getAllPartners();
	}

	@GetMapping("/{id}")
	public DeliveryPartnerDto getPartnerById(@PathVariable("id") String partnerId) {
		return partnerService.getPartnerById(partnerId);
	}

	@PostMapping
	public DeliveryPartnerDto createPartner(@RequestBody DeliveryPartnerDto partnerDto) {
		return partnerService.createPartner(partnerDto);
	}

	@PutMapping("/{id}")
	public DeliveryPartnerDto updatePartner(@PathVariable("id") String partnerId,
			@RequestBody DeliveryPartnerDto partnerDto) {
		return partnerService.updatePartner(partnerId, partnerDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePartner(@PathVariable("id") String partnerId) {
		partnerService.deletePartner(partnerId);
		return ResponseEntity.noContent().build();
	}

}
