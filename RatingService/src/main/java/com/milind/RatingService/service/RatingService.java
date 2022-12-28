package com.milind.RatingService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milind.RatingService.entity.Rating;


public interface RatingService {
	
	
	//create rating
	Rating create(Rating rating);
	
	//getall rating
	
	List<Rating> getrating();
	
	//getall by userid
	List<Rating> getratingbyuser(String userId);
	
	
	//getall by hotelid
	List<Rating> getratingbyhotel(String hotelId);
	
}
