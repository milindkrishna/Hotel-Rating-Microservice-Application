package com.milind.hotel.HotelService.Services;

import java.util.List;

import com.milind.hotel.HotelService.entities.Hotel;

public interface HotelService {
	
	//create
	
	Hotel create(Hotel hotel);
	
	//getall
	
	List<Hotel> getAll();
	
	//get single
	
	Hotel get(String id);
}
