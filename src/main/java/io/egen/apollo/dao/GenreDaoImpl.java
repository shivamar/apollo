package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Genre;

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
public class GenreDaoImpl implements GenreDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Genre> findAllMovieGenre() {		
		Query findAllQuery = em.createNamedQuery("genre.findAll");//"SELECT m FROM MOVIE m ORDER BY m.title ASC", Movie.class);		
    	List<Genre> genre = findAllQuery.getResultList();
    	return genre;
	}

	@Override
	public Genre findMovieGenreById(String id) {
		return em.find(Genre.class, id);
	}

	@Override
	public Genre createMovieGenre(Genre Genre) {
		em.persist(Genre);
		return Genre;
	}

	@Override
	public Genre updateMovieGenre(String id, Genre Genre) {
		
		return em.merge(Genre);
	}

	@Override
	public void deleteMovieGenre(Genre genre) {
		genre = em.find(Genre.class, genre.getGenre_id());
		em.remove(genre);
	}
}