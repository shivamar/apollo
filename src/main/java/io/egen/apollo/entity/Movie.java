package io.egen.apollo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="movie")
public class Movie {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	String movie_id;	
	
	String title;
	
	int year;
	String rated;
	String runtime;
	String plot;
	String language;
	String country;
	String awards;
	String poster;
	int metaScore;
	float imdb_rating;
	float imdb_votes;
	String imdb_id; 
	float movie_flix_rating;
	
	@OneToOne
	MovieType type;
	
	//secondary table
	@ManyToMany(mappedBy = "movie", 
	        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	Set<Genre> genre;
	
	//secondary table
	@ManyToMany(mappedBy="crew")
	Set<Crew> crew;
	
	@OneToMany(mappedBy="movie")
	List<Comment> comments;
}