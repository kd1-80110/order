package com.app.service;

import java.util.List;

import com.app.dto.DeliveryPartnerDto;

public interface DeliveryPartnerService {

	List<DeliveryPartnerDto> getAllPartners();

	DeliveryPartnerDto getPartnerById(String partnerId);

	DeliveryPartnerDto createPartner(DeliveryPartnerDto partnerDto);

	DeliveryPartnerDto updatePartner(String partnerId, DeliveryPartnerDto partnerDto);

	void deletePartner(String partnerId);

}
