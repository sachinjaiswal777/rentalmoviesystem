package com.bigmovies.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigmovies.model.BookedMovie;
import com.bigmovies.model.Customer;
import com.bigmovies.model.Movie;
import com.bigmovies.model.MoviePriceDetails;
import com.bigmovies.model.MovieRental;
import com.bigmovies.repo.MovieRepo;
import com.bigmovies.service.MovieService;
import com.bigmovies.util.Constants;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;

	@Override
	public BookedMovie rentalMovie(Customer customer) {

		double totalAmount = 0;
		int frequentEnterPoints = 0;
		
		BookedMovie bookedMovie = new BookedMovie();
		ArrayList<MoviePriceDetails> moviePriceList = new ArrayList<MoviePriceDetails>();

		for (MovieRental r : customer.getRentals()) {
			MoviePriceDetails mps = new MoviePriceDetails();
			double thisAmount = 0;
			Movie movies = movieRepo.getMovieDetail(r.getMovieId());

			// determine amount for each movie
			if (movies.getCode().equals(Constants.REGULAR)) {
				thisAmount = 2;
				if (r.getDays() > 2) {
					thisAmount = ((r.getDays() - 2) * 1.5) + thisAmount;
				}
			} else if (movies.getCode().equals(Constants.NEW)) {
				thisAmount = r.getDays() * 3;

				// add bonus for a two day new release rental
				if (r.getDays() > 2)
					frequentEnterPoints++;
			} else if (movies.getCode().equals(Constants.CHILDRENS)) {
				thisAmount = 1.5;
				if (r.getDays() > 3) {
					thisAmount = ((r.getDays() - 3) * 1.5) + thisAmount;
				}
			}

			// add frequent bonus points
			frequentEnterPoints++;

			// print figures for this rental
			mps.setPrice(thisAmount);
			mps.setTitle(movies.getTitle());
			moviePriceList.add(mps);

			totalAmount = totalAmount + thisAmount;
		}

		Customer customerInfo = new Customer(customer.getName(), null);
		bookedMovie.setThisAmount(totalAmount);
		bookedMovie.setRentalMovies(moviePriceList);
		bookedMovie.setFrequentEnterPoints(frequentEnterPoints);
		bookedMovie.setCustomer(customerInfo);

		return bookedMovie;
	}

}
