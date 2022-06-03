package com.bigmovies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigmovies.model.BookedMovie;
import com.bigmovies.model.Customer;
import com.bigmovies.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@PostMapping("/rental/order")
	public ResponseEntity<BookedMovie> rentalMovie(@RequestBody Customer customer) {
		BookedMovie bookedMovie = movieService.rentalMovie(customer);
		return ResponseEntity.ok(bookedMovie);	
	}
}
