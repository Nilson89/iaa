package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Studienrichtung;

/**
 * 
 * @author Niels Maseberg
 */
public interface PruefungsleistungenService {
	public List<Pruefungsleistung> listNoten(Integer jahrgang, Studienrichtung studienrichtung);
}