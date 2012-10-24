package de.nordakademie.hausarbeit.service;

import java.util.Date;
import java.util.List;

import de.nordakademie.hausarbeit.dao.PruefungenDAO;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungenServiceImpl implements PruefungenService {
	private PruefungenDAO pruefungenDAO;
	
	/**
	 * getHistoriePruefungen
	 * 
	 * @param Student
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> getHistoriePruefungen(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * listPruefungen
	 * 
	 * @param Long
	 * @return List<Pruefung>
	 */
	public List<Pruefung> listPruefungen(Long pruefungsfachId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * createPruefung
	 * 
	 * @param Long
	 * @param Date
	 * @param Long
	 * @return Boolean
	 */
	public boolean createPruefung(Long pruefungsfachId, Date datum, Long dozentId) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * checkPruefungExists
	 * 
	 * @param Long
	 * @param Date
	 * @param Long
	 * @return Boolean
	 */
	public boolean checkPruefungExists(Long pruefungsfachId, Date datum, Long dozentId) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param pruefungenDAO the pruefungenDAO to set
	 */
	public void setPruefungenDAO(PruefungenDAO pruefungenDAO) {
		this.pruefungenDAO = pruefungenDAO;
	}

}