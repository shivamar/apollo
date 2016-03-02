package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.MovieType;

import java.util.List;

public interface Movie_TypeDao {
	public List<MovieType> findAllMovieType ();
	public MovieType findMovieTypeById(String id); //throws MovieNotFoundException;
	public MovieType createMovieType(MovieType MovieType); //throws MovieAlreadyExistsException;
	public MovieType updateMovieType(String id, MovieType Movie); //throws MovieNotFoundException;
	public void deleteMovieType(MovieType movieType);// throws MovieNotFoundException;
}
