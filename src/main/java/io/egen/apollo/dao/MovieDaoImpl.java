package io.egen.apollo.dao;
import io.egen.apollo.entity.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

	@PersistenceContext
	private EntityManager em;
		
	@Override
	public List<Movie> findAllMovies() {
		Query findAllQuery = em.createNamedQuery("movie.findAll");
		List<Movie> movies = findAllQuery.getResultList();
//		TypedQuery<Movie> query = (TypedQuery<Movie>) em.createNamedQuery("movie.findAll");//"SELECT m FROM MOVIE m ORDER BY m.title ASC", Movie.class);
//    	List<Movie> movies = query.getResultList();
    	return movies;
	}

	@Override
	public Movie findMovieById(String id) {		
		return em.find(Movie.class, id);
	}
	
	@Override
	public Movie createMovie(Movie movie) {		
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {		
		return em.merge(movie);
	}

	@Override
	public void deleteMovie(Movie movie) {
		movie = em.find(Movie.class, movie.getMovie_id());
		em.remove(movie);		
	}
}