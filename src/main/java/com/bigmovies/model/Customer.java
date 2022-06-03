package com.bigmovies.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private List<MovieRental> rentals;
}
