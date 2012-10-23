package de.nordakademie.hausarbeit.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Niels Maseberg
 */
public class Student {
	private int matrikelnummer;
	private Person person;
	
	/**
	 * @return the matrikelnummer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	/**
	 * @param matrikelnummer the matrikelnummer to set
	 */
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	/**
	 * @return the person
	 */
	@OneToOne
	@JoinColumn(name= "personid")
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
