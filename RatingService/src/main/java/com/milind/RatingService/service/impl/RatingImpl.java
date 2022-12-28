package com.milind.RatingService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milind.RatingService.entity.Rating;
import com.milind.RatingService.repository.RatingRepository;
import com.milind.RatingService.service.RatingService;

@Service
public class RatingImpl implements RatingService {
	
	@Autowired
	private RatingRepository repo;
	
	@Override
	public Rating create(Rating rating) {
		
		return repo.save(rating);
	}

	@Override
	public List<Rating> getrating() {
		
		return repo.findAll();
	}

	@Override
	public List<Rating> getratingbyuser(String userId) {
		
		return repo.findByUserId(userId);
	}

	@Override
	public List<Rating> getratingbyhotel(String hotelId) {
		
		return repo.findByHotelId(hotelId);
	}

}
