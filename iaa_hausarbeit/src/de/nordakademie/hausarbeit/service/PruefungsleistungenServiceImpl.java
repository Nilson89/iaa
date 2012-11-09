package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.PruefungsleistungenDAO;
import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.model.Studienrichtung;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungsleistungenServiceImpl implements PruefungsleistungenService {
	private PruefungsleistungenDAO pruefungsleistungenDAO;
	
	/**
	 * listNoten
	 * 
	 * @param Integer the jahrgang to list noten for
	 * @param Studienrichtung the studienrichtung to list noten for
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> listNoten(Integer jahrgang, Studienrichtung studienrichtung) {
		return pruefungsleistungenDAO.loadPruefungsleistungenByJahrgangAndStudienrichtung(jahrgang, studienrichtung);
	}

	/**
	 * getPruefungsleistungById
	 * 
	 * @param Long the pruefungsleistungId
	 * @return the Pruefungsleistung
	 */
	public Pruefungsleistung getPruefungsleistungById(Long pruefungsleistungId) {
		return pruefungsleistungenDAO.loadPruefungsleistungById(pruefungsleistungId);
	}

	/**
	 * markPruefungsleistungAsInvalid
	 * 
	 * @param Pruefungsleistung the pruefungsleistung
	 */
	public void markPruefungsleistungAsInvalid(Pruefungsleistung pruefungsleistung) {
		pruefungsleistung.setGueltig(false);
		pruefungsleistungenDAO.savePruefungsleistung(pruefungsleistung);
	}

	/**
	 * createPruefungsleistung
	 * 
	 * @param pruefungsleistung the pruefungsleistung
	 * @return Pruefungsleistung
	 */
	public Pruefungsleistung createPruefungsleistung(Pruefungsleistung pruefungsleistung) {
		return pruefungsleistungenDAO.savePruefungsleistung(pruefungsleistung);
	}

	/**
	 * @param pruefungsleistungenDAO the pruefungsleistungenDAO to set
	 */
	public void setPruefungsleistungenDAO(
			PruefungsleistungenDAO pruefungsleistungenDAO) {
		this.pruefungsleistungenDAO = pruefungsleistungenDAO;
	}

	/**
	 * getHistoriePruefungen
	 */
	public List<Pruefungsleistung> getHistoriePruefungen(Student student, Pruefungsfach pruefungsfach) {
		return pruefungsleistungenDAO.loadPruefungsleistungenForStudentAndPruefungsfach(student, pruefungsfach);
	}

	/**
	 * createErgaenzungspruefung
	 * 
	 * @param Ergaenzungspruefung the ergaenzungspruefung to store
	 * @return Ergaenzungspruefung
	 */
	public Ergaenzungspruefung createErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung) {
		return pruefungsleistungenDAO.saveErgaenzungspruefung(ergaenzungspruefung);
	}
	

}