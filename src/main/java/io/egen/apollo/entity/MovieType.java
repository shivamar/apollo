package io.egen.apollo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="movie_type")
@NamedQueries({
@NamedQuery(name="movieType.findAll",
    query="SELECT m FROM MovieType m")         
})
public @Data class MovieType {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator (name="uuid2",strategy="uuid2")
	String movie_type_id;
	
	String type;	
	/* In future if you want the data to be bi directional uncomment the 3 lined below
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movies;  */
}