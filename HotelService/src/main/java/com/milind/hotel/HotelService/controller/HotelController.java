package com.milind.hotel.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milind.hotel.HotelService.Services.HotelService;
import com.milind.hotel.HotelService.entities.Hotel;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	
	//create api
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
	}
	
	//getall api
	@GetMapping
	public ResponseEntity<List<Hotel>> getall(){
		return ResponseEntity.ok(service.getAll());
	}
	
	//get single api
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> get(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.get(hotelId));
	}
}
