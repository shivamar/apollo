package io.egen.apollo.service;

import io.egen.apollo.dao.MovieDao;
import io.egen.apollo.dao.CommentDao;
import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;	
	
	@Override
	public List<Comment> findAllMovieComment() {
		
		return dao.findAllMovieComment();
	}

	@Override
	public Comment findMovieCommentById(String id) {
		
		return dao.findMovieCommentById(id);
	}

	@Override
	public Comment createMovieComment(Comment Movie) {
		
		return dao.createMovieComment(Movie);
	}

	@Override
	public Comment updateMovieComment(String id, Comment comment) {
		
		return dao.updateMovieComment(id, comment);
	}

	@Override
	public void deleteMovieComment(Comment comment) {
		dao.deleteMovieComment(comment);
		
	}

	@Override
	public List<Comment> findAllCommentsOfAMovie(String movie_id) {		
		return dao.findAllCommentsOfAMovie(movie_id);
	}

}
