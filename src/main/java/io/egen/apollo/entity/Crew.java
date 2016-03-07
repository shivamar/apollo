package io.egen.apollo.entity;

import java.util.List;
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

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="crew")
public @Data class Crew {	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String crew_id;
	
	private String name;
	
//	@OneToMany(mappedBy="role_id")
//	private List<Role> role;	
    
	private String role;
	
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
	
	//@JsonIgnore
	@JoinColumn(name="movie_id")
	private Set<Movie> movie; 
}
