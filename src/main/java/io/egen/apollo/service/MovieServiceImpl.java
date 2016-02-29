package io.egen.apollo.service;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

public class MovieServiceImpl implements 
MovieService{

	@Override
	public List<Movie> findAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findMovieById(String id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie createMovie(Movie Movie) throws MovieAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie updateMovie(String id, Movie Movie)
			throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(String id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
