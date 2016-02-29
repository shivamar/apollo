package io.egen.apollo.service;

import io.egen.apollo.dao.MovieDao;
import io.egen.apollo.entity.Movie;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieServiceImpl implements 
MovieService{

	@Autowired
	MovieDao dao;
	
	@Override
	public List<Movie> findAllMovies() {
		
		return dao.findAllMovies();
	}

	@Override
	public Movie findMovieById(String id) throws MovieNotFoundException {
		Movie movie =  dao.findMovieById(id);
		if(movie == null) {
			throw new MovieNotFoundException();
		}
		else {
			return movie;
		}
	}

	@Override
	public Movie createMovie(Movie movie) throws MovieAlreadyExistsException {
		String id =  movie.getMovie_id();
		if(id == null || id.isEmpty()) {
			return dao.createMovie(movie);
		}
		else {
			throw new MovieAlreadyExistsException();
		}
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
