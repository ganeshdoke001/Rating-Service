package com.lcwd.rating.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RetingRest {

	@Autowired
	private RatingService ratingService;

	@PreAuthorize("hasAuthority('Admin') ")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		return ResponseEntity.ok(this.ratingService.create(rating));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Rating>> getAllRatings() {
		return ResponseEntity.ok(this.ratingService.getAllRatings());

	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin') ")
	@GetMapping("/user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String userId) {
		return ResponseEntity.ok(this.ratingService.getRatingByUserId(userId));

	}

	@GetMapping("/hotel/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String hotelId) {
		return ResponseEntity.ok(this.ratingService.getRatingByHotelId(hotelId));

	}
}
