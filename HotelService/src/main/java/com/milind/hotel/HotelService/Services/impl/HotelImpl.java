package com.milind.hotel.HotelService.Services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milind.hotel.HotelService.Repository.HotelRepo;
import com.milind.hotel.HotelService.Services.HotelService;
import com.milind.hotel.HotelService.entities.Hotel;
import com.milind.hotel.HotelService.exception.ResourceNotFoundException;

@Service
public class HotelImpl implements HotelService {
	
	@Autowired
	private HotelRepo repo;
	
	@Override
	public Hotel create(Hotel hotel) {
		
		String UID = UUID.randomUUID().toString();
		hotel.setId(UID);
		
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return repo.findAll();
	}

	@Override
	public Hotel get(String id) {
		
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
	}

}
