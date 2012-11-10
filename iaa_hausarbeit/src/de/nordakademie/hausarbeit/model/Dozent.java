package de.nordakademie.hausarbeit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Dozent {
	private Long id;
	private Person person;
	
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
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return person
	 */
	@OneToOne
	@JoinColumn(name= "personid")
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person 
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}