package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entity.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
	
}
