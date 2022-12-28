package com.milind.RatingService.controller;

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

import com.milind.RatingService.entity.Rating;
import com.milind.RatingService.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	//create api
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
	}
	
	//getall rating api
	@GetMapping
	public ResponseEntity<List<Rating>> getrating(){
		return ResponseEntity.ok(service.getrating());
	}
	
	//getrating by userid api
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getratingbyuser(@PathVariable String userId){
		return ResponseEntity.ok(service.getratingbyuser(userId));
	}
	
	//getrating by hotelid api
		@GetMapping("/hotel/{hotelId}")
		public ResponseEntity<List<Rating>> getratingbyhotel(@PathVariable String hotelId){
			return ResponseEntity.ok(service.getratingbyhotel(hotelId));
		}
}
