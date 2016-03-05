package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Comment;

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
public class CommentDaoImpl implements CommentDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> findAllMovieComment() {		
		Query findAllQuery = em.createNamedQuery("comment.findAll");//"SELECT m FROM MOVIE m ORDER BY m.title ASC", Movie.class);		
    	List<Comment> comment = findAllQuery.getResultList();
    	return comment;
	}

	@Override
	public Comment findMovieCommentById(String id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment createMovieComment(Comment Comment) {
		em.persist(Comment);
		return Comment;
	}

	@Override
	public Comment updateMovieComment(String id, Comment Comment) {
		
		return em.merge(Comment);
	}

	@Override
	public void deleteMovieComment(Comment comment) {
		comment = em.find(Comment.class, comment.getComment_id());
		em.remove(comment);
	}
}