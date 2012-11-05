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
	public List<Pruefungsleistung> getHistoriePruefungen(Student student);
	public List<Pruefung> listPruefungen(Long pruefungsfachId);
	public boolean createPruefung(Long pruefungsfachId, Date datum, Long dozentId);
	public boolean checkPruefungExists(Long pruefungsfachId, Date datum, Long dozentId);
}