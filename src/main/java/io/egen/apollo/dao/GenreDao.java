package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Genre;

import java.util.List;

public interface GenreDao {
	public List<Genre> findAllMovieGenre ();
	public Genre findMovieGenreById(String id); //throws MovieNotFoundException;
	public Genre createMovieGenre(Genre Genre); //throws MovieAlreadyExistsException;
	public Genre updateMovieGenre(String id, Genre Movie); //throws MovieNotFoundException;
	public void deleteMovieGenre(Genre genre);// throws MovieNotFoundException;
}
