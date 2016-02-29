package io.egen.apollo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="genre")
public class Genre {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	String genre_id;
	
	String type;
		
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="movie_genre",
			joinColumns={
			@JoinColumn(name="movie_id", referencedColumnName="movie_id"),				
			}
			, inverseJoinColumns={				
				@JoinColumn(name="genre_id", referencedColumnName="genre_id")
	})	
	private Set<Movie> movie;			
}
