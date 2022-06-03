package com.bigmovies.model;

import java.util.List;

import lombok.Data;

@Data
public class BookedMovie {	
	private Integer frequentEnterPoints;
	private double thisAmount;
	private Customer customer;
	private List<MoviePriceDetails> rentalMovies;
}
