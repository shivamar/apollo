package io.egen.apollo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private String role_id;
	
	String role_type;
	
/*	 In future if you want the data to be bi directional uncomment the 3 lined below
 * @ManyToOne
	@JoinColumn(name="crew_id")
	private Crew crew; */
}