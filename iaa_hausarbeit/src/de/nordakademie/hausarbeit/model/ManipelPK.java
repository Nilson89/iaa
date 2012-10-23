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
}
