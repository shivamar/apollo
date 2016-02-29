package io.egen.apollo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comment")
public class Comment {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator (name="uuid2",strategy="uuid2")
	String comment_id;
	
	String comment;	
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movies;	

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
