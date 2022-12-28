package com.milind.hotel.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milind.hotel.HotelService.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
