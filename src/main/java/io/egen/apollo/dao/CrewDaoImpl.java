package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Crew;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CrewDaoImpl implements CrewDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Crew> findAllMovieCrew() {		
		Query findAllQuery = em.createNamedQuery("crew.findAll");//"SELECT m FROM MOVIE m ORDER BY m.title ASC", Movie.class);		
    	List<Crew> crew = findAllQuery.getResultList();
    	return crew;
	}

	@Override
	public Crew findMovieCrewById(String id) {
		return em.find(Crew.class, id);
	}

	@Override
	public Crew createMovieCrew(Crew Crew) {
		em.persist(Crew);
		return Crew;
	}

	@Override
	public Crew updateMovieCrew(String id, Crew Crew) {
		
		return em.merge(Crew);
	}

	@Override
	public void deleteMovieCrew(Crew crew) {
		crew = em.find(Crew.class, crew.getCrew_id());
		em.remove(crew);
	}
}