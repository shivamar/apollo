package io.egen.apollo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="movie")
@NamedQueries({
@NamedQuery(name="movie.findAll",
    query="SELECT m FROM Movie m ORDER BY m.title ASC")         
})
public @Data class Movie {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String movie_id;	
	
	private String title;
	
	private int year;
	private String rated;
	private String runtime;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metaScore;
	private float imdb_rating;
	private float imdb_votes;
	private String imdb_id; 
	private float movie_flix_rating;
	
	private String imdb_link;
	private int user_rating_count;
	
	@ManyToOne
	@JoinColumn(name="movie_type_id")
	private MovieType type;
			
}

/*
//secondary table
@ManyToMany(mappedBy = "movie", 
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private Set<Genre> genres;

//secondary table
@ManyToMany(mappedBy = "movie", 
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private Set<Crew> crews;

@OneToMany(mappedBy="movie")
private Set<Comment> comments;	
*/