package io.egen.apollo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="crew")
public class Crew {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String crew_id;
	
	private String name;
	
	@OneToMany
	private Role role;	
		
	@ManyToMany
	@JoinTable(
			name="movie_crew",
			joinColumns={
					@JoinColumn(name="crew_id",
							referencedColumnName="crew_id")
 					
			},
			inverseJoinColumns={
					@JoinColumn(name="movie_id"
							, referencedColumnName="movie_id")
			}
	)
	private Set<Movie> movie; 
}
