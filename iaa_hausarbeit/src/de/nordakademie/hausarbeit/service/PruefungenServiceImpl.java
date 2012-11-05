package de.nordakademie.hausarbeit.service;

import java.util.Date;
import java.util.List;

import de.nordakademie.hausarbeit.dao.PruefungenDAO;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg, Sabrina Schramm
 */
public class PruefungenServiceImpl implements PruefungenService {
	private PruefungenDAO pruefungenDAO;
	
	/**
	 * getHistoriePruefungen
	 * 
	 * @param student the student to get the history for
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> getHistoriePruefungen(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * listPruefungen
	 * 
	 * @param pruefungsfachId the Id of the pruefungsfach
	 * @return List<Pruefung>
	 */
	public List<Pruefung> listPruefungen(Long pruefungsfachId) {
		return pruefungenDAO.loadPruefungen(pruefungsfachId);
	}

	/**
	 * createPruefung
	 * 
	 * @param pruefungsfachId the Id of the pruefungsfach
	 * @param datum the date of the pruefung
	 * @param dozentId the dozent of the pruefung
	 * @return Boolean
	 */
	public boolean createPruefung(Long pruefungsfachId, Date datum, Long dozentId) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * checkPruefungExists
	 * 
	 * @param pruefungsfachId the Id of the pruefungsfach
	 * @param datum the date of the pruefung
	 * @param dozentId the dozent of the pruefung
	 * @return Boolean
	 */
	public boolean checkPruefungExists(Long pruefungsfachId, Date datum, Long dozentId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * savePruefung
	 * 
	 * @param pruefung
	 * @return pruefung
	 */
	@Override
	public Pruefung savePruefung(Pruefung pruefung) {
		return pruefungenDAO.saveOrUpdatePruefung(pruefung);
	}

	/**
	 * @param pruefungenDAO the pruefungenDAO to set
	 */
	public void setPruefungenDAO(PruefungenDAO pruefungenDAO) {
		this.pruefungenDAO = pruefungenDAO;
	}

}