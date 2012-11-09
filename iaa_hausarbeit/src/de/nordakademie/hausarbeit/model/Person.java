package de.nordakademie.hausarbeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Person {
	private Long id;
	private String name;
	private String vorname;
	
	/**
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id 
	 */
	@Column(nullable = true)
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name 
	 */
	@Column(nullable = true)
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname 
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/*
	 * @return String the Fullname
	 */
	@Transient
	public String getFullName() {
		return vorname + " " + name;		
	}
}