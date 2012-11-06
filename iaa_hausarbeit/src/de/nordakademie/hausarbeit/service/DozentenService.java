package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Dozent;

/**
 * 
 * @author Sabrina Schramm und Niels Maseberg
 */

public interface DozentenService {
	public List<Dozent> getDozentenList();
	public Dozent getById(Long id);
}
