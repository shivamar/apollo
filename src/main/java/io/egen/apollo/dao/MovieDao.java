package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;

import java.util.List;

public interface MovieDao {
	public List<Movie> findAllMovies();
	public Movie findMovieById(String id);
	public Movie findMovieByEmail(String email);
	public Movie createMovie(Movie user);
	public Movie updateMovie(Movie user);
	public void deleteMovie(Movie user);
}
