package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Crew;

import java.util.List;

public interface CrewDao {
	public List<Crew> findAllMovieCrew ();
	public Crew findMovieCrewById(String id); //throws MovieNotFoundException;
	public Crew createMovieCrew(Crew Crew); //throws MovieAlreadyExistsException;
	public Crew updateMovieCrew(String id, Crew Movie); //throws MovieNotFoundException;
	public void deleteMovieCrew(Crew Crew);// throws MovieNotFoundException;
}
