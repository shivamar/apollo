package io.egen.apollo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="genre")
@NamedQueries({
@NamedQuery(name="genre.findAll",
    query="SELECT g FROM Genre g ORDER BY g.type ASC")         
})
public @Data class Genre {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String genre_id;
	
	private String type;
		
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="movie_genre",
			joinColumns={
			@JoinColumn(name="genre_id", referencedColumnName="genre_id")				
			}
			, inverseJoinColumns={				
			@JoinColumn(name="movie_id", referencedColumnName="movie_id"),
	})	

	@JoinColumn(name="movie_id")
	private Set<Movie> movie;			
}
