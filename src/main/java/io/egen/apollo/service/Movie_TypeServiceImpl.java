package io.egen.apollo.service;

import io.egen.apollo.dao.MovieDao;
import io.egen.apollo.dao.Movie_TypeDao;
import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.MovieType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_TypeServiceImpl implements Movie_TypeService {

	@Autowired
	Movie_TypeDao dao;
	
	
	@Override
	public List<MovieType> findAllMovieType() {
		
		return dao.findAllMovieType();
	}

	@Override
	public MovieType findMovieTypeById(String id) {
		
		return dao.findMovieTypeById(id);
	}

	@Override
	public MovieType createMovieType(MovieType Movie) {
		
		return dao.createMovieType(Movie);
	}

	@Override
	public MovieType updateMovieType(String id, MovieType movieType) {
		
		return dao.updateMovieType(id, movieType);
	}

	@Override
	public void deleteMovieType(MovieType movieType) {
		dao.deleteMovieType(movieType);
		
	}

}
