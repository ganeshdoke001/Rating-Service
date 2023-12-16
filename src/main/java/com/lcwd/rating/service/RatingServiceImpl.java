package com.lcwd.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		String id=UUID.randomUUID().toString();
		rating.setRatingId(id);
		return this.ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return this.ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return this.ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return this.ratingRepo.findByHotelId(hotelId);
	}



}
