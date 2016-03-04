package io.egen.apollo.service;

import java.util.List;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

public interface MovieService {	
	public List<Movie> findAllMovies ();
	public Movie findMovieById(String id) throws MovieNotFoundException;
	public Movie createMovie(Movie Movie) throws MovieAlreadyExistsException;
	public Movie updateMovie(String id, Movie Movie) throws MovieNotFoundException;
	public void deleteMovie(String id) throws MovieNotFoundException;
}
