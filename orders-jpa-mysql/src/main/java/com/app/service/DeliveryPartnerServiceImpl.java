package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DeliveryPartnerDao;
import com.app.dto.DeliveryPartnerDto;
import com.app.entity.DeliveryPartner;

@Service
@Transactional
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

	@Autowired
	private DeliveryPartnerDao deliveryPartnerDao;

	@Override
	public List<DeliveryPartnerDto> getAllPartners() {
		return deliveryPartnerDao.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public DeliveryPartnerDto getPartnerById(String partnerId) {
		return convertToDto(
				deliveryPartnerDao.findById(partnerId).orElseThrow(() -> new RuntimeException("Partner not found")));
	}

	@Override
	public DeliveryPartnerDto createPartner(DeliveryPartnerDto partnerDto) {
		DeliveryPartner partner = new DeliveryPartner();
		BeanUtils.copyProperties(partnerDto, partner);
		return convertToDto(deliveryPartnerDao.save(partner));
	}

	@Override
	public DeliveryPartnerDto updatePartner(String partnerId, DeliveryPartnerDto partnerDto) {
		DeliveryPartner partner = deliveryPartnerDao.findById(partnerId)
				.orElseThrow(() -> new RuntimeException("Partner not found"));
		BeanUtils.copyProperties(partnerDto, partner);
		return convertToDto(deliveryPartnerDao.save(partner));
	}

	@Override
	public void deletePartner(String partnerId) {
		deliveryPartnerDao.deleteById(partnerId);
	}

	private DeliveryPartnerDto convertToDto(DeliveryPartner partner) {
		DeliveryPartnerDto partnerDto = new DeliveryPartnerDto();
		BeanUtils.copyProperties(partner, partnerDto);
		return partnerDto;
	}

}
