package io.egen.apollo.service;

import io.egen.apollo.dao.MovieDao;
import io.egen.apollo.dao.GenreDao;
import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreDao dao;
	
	
	@Override
	public List<Genre> findAllMovieGenre() {
		
		return dao.findAllMovieGenre();
	}

	@Override
	public Genre findMovieGenreById(String id) {
		
		return dao.findMovieGenreById(id);
	}

	@Override
	public Genre createMovieGenre(Genre Movie) {
		
		return dao.createMovieGenre(Movie);
	}

	@Override
	public Genre updateMovieGenre(String id, Genre genre) {
		
		return dao.updateMovieGenre(id, genre);
	}

	@Override
	public void deleteMovieGenre(Genre genre) {
		dao.deleteMovieGenre(genre);
		
	}

}
