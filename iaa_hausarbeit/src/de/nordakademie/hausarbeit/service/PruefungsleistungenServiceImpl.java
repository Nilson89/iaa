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
	 * @param jahrgang
	 * @param studienrichtung
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> listNoten(Integer jahrgang, Studienrichtung studienrichtung) {
		return pruefungsleistungenDAO.loadPruefungsleistungenByJahrgangAndStudienrichtung(jahrgang, studienrichtung);
	}

	/**
	 * getPruefungsleistungById
	 * 
	 * @param pruefungsleistungId
	 * @return pruefungsleistung
	 */
	public Pruefungsleistung getPruefungsleistungById(Long pruefungsleistungId) {
		return pruefungsleistungenDAO.loadPruefungsleistungById(pruefungsleistungId);
	}

	/**
	 * markPruefungsleistungAsInvalid
	 * 
	 * @param pruefungsleistung
	 */
	public void markPruefungsleistungAsInvalid(Pruefungsleistung pruefungsleistung) {
		pruefungsleistung.setGueltig(false);
		pruefungsleistungenDAO.savePruefungsleistung(pruefungsleistung);
	}

	/**
	 * createPruefungsleistung
	 * 
	 * @param pruefungsleistung
	 * @return Pruefungsleistung
	 */
	public Pruefungsleistung createPruefungsleistung(Pruefungsleistung pruefungsleistung) {
		return pruefungsleistungenDAO.savePruefungsleistung(pruefungsleistung);
	}

	/**
	 * @param pruefungsleistungenDAO
	 */
	public void setPruefungsleistungenDAO(
			PruefungsleistungenDAO pruefungsleistungenDAO) {
		this.pruefungsleistungenDAO = pruefungsleistungenDAO;
	}

	/**
	 * getHistoriePruefungen
	 * @return pruefungsleistungen
	 */
	public List<Pruefungsleistung> getHistoriePruefungen(Student student, Pruefungsfach pruefungsfach) {
		return pruefungsleistungenDAO.loadPruefungsleistungenForStudentAndPruefungsfach(student, pruefungsfach);
	}

	/**
	 * createErgaenzungspruefung
	 * 
	 * @param ergaenzungspruefung
	 * @return ergaenzungspruefung
	 */
	public Ergaenzungspruefung createErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung) {
		return pruefungsleistungenDAO.saveErgaenzungspruefung(ergaenzungspruefung);
	}
	

}