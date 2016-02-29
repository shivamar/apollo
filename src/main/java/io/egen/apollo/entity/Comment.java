package io.egen.apollo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comment")
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
