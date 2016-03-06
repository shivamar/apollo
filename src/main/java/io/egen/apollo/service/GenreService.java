package io.egen.apollo.service;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Genre;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

public interface GenreService {
	public List<Genre> findAllMovieGenre ();
	public Genre findMovieGenreById(String id); //throws MovieNotFoundException;
	public Genre createMovieGenre(Genre Genre); //throws MovieAlreadyExistsException;
	public Genre updateMovieGenre(String id, Genre Movie); //throws MovieNotFoundException;
	public void deleteMovieGenre(Genre id);// throws MovieNotFoundException;
}
