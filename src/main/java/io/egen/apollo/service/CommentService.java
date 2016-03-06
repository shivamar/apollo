package io.egen.apollo.service;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Comment;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;

import java.util.List;

public interface CommentService {
	public List<Comment> findAllMovieComment ();
	public Comment findMovieCommentById(String id); //throws MovieNotFoundException;
	public Comment createMovieComment(Comment Comment); //throws MovieAlreadyExistsException;
	public Comment updateMovieComment(String id, Comment Movie); //throws MovieNotFoundException;
	public void deleteMovieComment(Comment id);// throws MovieNotFoundException;
}
