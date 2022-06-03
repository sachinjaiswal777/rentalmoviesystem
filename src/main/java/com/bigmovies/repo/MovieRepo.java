package com.bigmovies.repo;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.bigmovies.model.Movie;

@Repository
public class MovieRepo {
	
	public Movie getMovieDetail(String movieCode) {
		
		HashMap<String, Movie> movies = new HashMap<>();
		
	    movies.put("F001", new Movie("You've Got Mail", "regular"));
	    movies.put("F002", new Movie("Matrix", "regular"));
	    movies.put("F003", new Movie("Cars", "childrens"));
	    movies.put("F004", new Movie("Fast & Furious X", "new"));	    
	    return movies.get(movieCode);
	}
}
