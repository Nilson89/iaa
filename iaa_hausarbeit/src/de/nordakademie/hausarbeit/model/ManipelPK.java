package de.nordakademie.hausarbeit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 
 * @author Niels Maseberg
 */
@Embeddable
public class ManipelPK implements Serializable {
	private static final long serialVersionUID = 6486310882753318031L;

	private int jahrgang;
	
	@Enumerated(EnumType.STRING)
	private Studienrichtung studienrichtung;

	/**
	 * @return jahrgang
	 */
	public int getJahrgang() {
		return jahrgang;
	}

	/**
	 * @param jahrgang
	 */
	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}

	/**
	 * @return studienrichtung
	 */
	public Studienrichtung getStudienrichtung() {
		return studienrichtung;
	}

	/**
	 * @param studienrichtung 
	 */
	public void setStudienrichtung(Studienrichtung studienrichtung) {
		this.studienrichtung = studienrichtung;
	}

	/**
	 * toString
	 */
	public String toString() {
		return studienrichtung.toString() + String.format("%d", jahrgang);
	}
}