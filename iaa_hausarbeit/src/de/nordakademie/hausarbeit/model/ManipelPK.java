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
	 * @return the jahrgang
	 */
	public int getJahrgang() {
		return jahrgang;
	}

	/**
	 * @param jahrgang the jahrgang to set
	 */
	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}

	/**
	 * @return the studienrichtung
	 */
	public Studienrichtung getStudienrichtung() {
		return studienrichtung;
	}

	/**
	 * @param studienrichtung the studienrichtung to set
	 */
	public void setStudienrichtung(Studienrichtung studienrichtung) {
		this.studienrichtung = studienrichtung;
	}
}