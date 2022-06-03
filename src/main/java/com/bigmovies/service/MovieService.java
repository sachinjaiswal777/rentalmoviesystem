package com.bigmovies.service;

import com.bigmovies.model.BookedMovie;
import com.bigmovies.model.Customer;

public interface MovieService {
	public BookedMovie rentalMovie(Customer customer);
}
