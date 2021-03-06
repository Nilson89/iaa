package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Dozent;
import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.model.Studienrichtung;

/**
 * 
 * @author Niels Maseberg
 */
public interface PruefungsleistungenService {
	public List<Pruefungsleistung> listNoten(Integer jahrgang, Studienrichtung studienrichtung);
	public List<Pruefungsleistung> getHistoriePruefungen(Student student, Pruefungsfach pruefungsfach);
	public Pruefungsleistung getPruefungsleistungById(Long pruefungsleistungId);
	public void markPruefungsleistungAsInvalid(Pruefungsleistung pruefungsleistung);
	public Pruefungsleistung createPruefungsleistung(Pruefungsleistung pruefungsleistung);
	public Ergaenzungspruefung createErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung);
}