package io.egen.apollo.dao;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Comment;

import java.util.List;

public interface CommentDao {
	public List<Comment> findAllMovieComment ();
	public Comment findMovieCommentById(String id); //throws MovieNotFoundException;
	public Comment createMovieComment(Comment Comment); //throws MovieAlreadyExistsException;
	public Comment updateMovieComment(String id, Comment Movie); //throws MovieNotFoundException;
	public void deleteMovieComment(Comment comment);// throws MovieNotFoundException;
}
