package de.nordakademie.hausarbeit.service;

import java.util.Date;
import java.util.List;

import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg, Sabrina Schramm
 */
public interface PruefungenService {
	public Pruefung savePruefung(Pruefung pruefung);
	public List<Pruefung> listPruefungen(Long pruefungsfachId);
	public boolean checkPruefungExists(Long pruefungsfachId, Date datum, Long dozentId);
}