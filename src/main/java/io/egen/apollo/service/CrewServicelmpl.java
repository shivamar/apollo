package io.egen.apollo.service;

import io.egen.apollo.dao.MovieDao;
import io.egen.apollo.dao.CrewDao;
import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Crew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewServicelmpl implements CrewService {

	@Autowired
	CrewDao dao;
	
	
	@Override
	public List<Crew> findAllMovieCrew() {
		
		return dao.findAllMovieCrew();
	}

	@Override
	public Crew findMovieCrewById(String id) {
		
		return dao.findMovieCrewById(id);
	}

	@Override
	public Crew createMovieCrew(Crew Movie) {
		
		return dao.createMovieCrew(Movie);
	}

	@Override
	public Crew updateMovieCrew(String id, Crew Crew) {
		
		return dao.updateMovieCrew(id, Crew);
	}

	@Override
	public void deleteMovieCrew (Crew Crew) {
		dao.deleteMovieCrew(Crew);
		
	}

}
