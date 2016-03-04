package io.egen.apollo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public @Data class User {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String user_id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@OneToOne
	@JoinColumn(name="user_role_id")
	private UserRole userRole; 
}
