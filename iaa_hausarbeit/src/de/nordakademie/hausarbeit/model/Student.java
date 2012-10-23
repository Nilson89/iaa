package de.nordakademie.hausarbeit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Student {
	private int matrikelnummer;
	private Person person;
	private Manipel manipel;
	
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
	
	/**
	 * @return the manipel
	 */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="manipelstudienrichtung", referencedColumnName="studienrichtung"),
		@JoinColumn(name="manipeljahrgang", referencedColumnName="jahrgang")
	})
	public Manipel getManipel() {
		return manipel;
	}
	/**
	 * @param manipel the manipel to set
	 */
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}
}
