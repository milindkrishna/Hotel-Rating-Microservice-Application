package com.milind.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.milind.user.service.entities.Hotel;
import com.milind.user.service.entities.Rating;
import com.milind.user.service.entities.User;
import com.milind.user.service.exceptions.ResourceNotFoundException;
import com.milind.user.service.externalservice.HotelService;
import com.milind.user.service.repositories.UserRepository;
import com.milind.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
    @Autowired
    private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveuser(User user) {
		// generate unique User Id
		String randomUserId = UUID.randomUUID().toString();
		user.setUserID(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// We can Implement Rating Service using RestTemplate
		return userRepository.findAll();
	}

	@Override
	public User getUser(String UserID) {
		
		User user = userRepository.findById(UserID).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+UserID));
		
		//fetch rating of above user using rating service
		//so url is -> http://localhost:8082/rating/user/6e3e0848-d0e6-4ff6-ab9f-2340b50db2a3
		//using rest template we can call the rating service
		
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserID(), Rating[].class);
		logger.info("{}",ratingsOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8081/hotel/"+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			//logger.info("{response status code}",forEntity.getStatusCode());
			
			rating.setHotel(hotel);
			return rating;
		
		}).collect(Collectors.toList());
		
		user.setRating(ratingList);
		return user;
	}

}
