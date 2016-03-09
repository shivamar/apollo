package io.egen.apollo.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comment")
@NamedQueries(value={
		@NamedQuery(name="comment.findAll", query= "select c from Comment c"),
		@NamedQuery(name="comment.findAllforAMovie", query="select c from Comment c where c.movie.movie_id=:movie_id")
	})
public @Data class Comment {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator (name="uuid2",strategy="uuid2")
	private String comment_id;
	
	private String comment;	
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
