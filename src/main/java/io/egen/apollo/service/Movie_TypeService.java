package io.egen.apollo.service;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.MovieType;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

public interface Movie_TypeService {
	public List<MovieType> findAllMovieType ();
	public MovieType findMovieTypeById(String id); //throws MovieNotFoundException;
	public MovieType createMovieType(MovieType MovieType); //throws MovieAlreadyExistsException;
	public MovieType updateMovieType(String id, MovieType Movie); //throws MovieNotFoundException;
	public void deleteMovieType(MovieType id);// throws MovieNotFoundException;
}
