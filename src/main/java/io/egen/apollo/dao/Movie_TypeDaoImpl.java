package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.MovieType;

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
public class Movie_TypeDaoImpl implements Movie_TypeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MovieType> findAllMovieType() {		
		Query findAllQuery = em.createNamedQuery("movieType.findAll");//"SELECT m FROM MOVIE m ORDER BY m.title ASC", Movie.class);		
    	List<MovieType> movieTypes = findAllQuery.getResultList();
    	return movieTypes;
	}

	@Override
	public MovieType findMovieTypeById(String id) {
		return em.find(MovieType.class, id);
	}

	@Override
	public MovieType createMovieType(MovieType MovieType) {
		em.persist(MovieType);
		return MovieType;
	}

	@Override
	public MovieType updateMovieType(String id, MovieType MovieType) {
		
		return em.merge(MovieType);
	}

	@Override
	public void deleteMovieType(MovieType movieType) {
		movieType = em.find(MovieType.class, movieType.getMovie_type_id());
		em.remove(movieType);
	}
}