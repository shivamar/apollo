package io.egen.apollo.service;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Crew;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

public interface CrewService {
	public List<Crew> findAllMovieCrew ();
	public Crew findMovieCrewById(String id); //throws MovieNotFoundException;
	public Crew createMovieCrew(Crew Crew); //throws MovieAlreadyExistsException;
	public Crew updateMovieCrew(String id, Crew Movie); //throws MovieNotFoundException;
	public void deleteMovieCrew(Crew id);// throws MovieNotFoundException;
}
