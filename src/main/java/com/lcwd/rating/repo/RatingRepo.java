package com.lcwd.rating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String userId);
}
