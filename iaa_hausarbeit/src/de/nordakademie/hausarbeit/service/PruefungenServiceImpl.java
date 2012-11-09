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
	 * listPruefungen
	 * 
	 * @param pruefungsfachId 
	 * @return List<Pruefung>
	 */
	public List<Pruefung> listPruefungen(Long pruefungsfachId) {
		return pruefungenDAO.loadPruefungen(pruefungsfachId);
	}

	/**
	 * checkPruefungExists
	 * 
	 * @param pruefungsfachId 
	 * @param datum 
	 * @param dozentId 
	 * @return Boolean
	 */
	public boolean checkPruefungExists(Long pruefungsfachId, Date datum, Long dozentId) {
		return pruefungenDAO.checkPruefungByPruefungsfachAndDateAndDozent(pruefungsfachId, datum, dozentId);
	}
	
	/**
	 * savePruefung
	 * 
	 * @param pruefung
	 * @return pruefung
	 */
	public Pruefung savePruefung(Pruefung pruefung) {
		return pruefungenDAO.saveOrUpdatePruefung(pruefung);
	}

	/**
	 * getPruefungById
	 * 
	 * @param pruefungId
	 * @return Pruefung
	 */
	public Pruefung getPruefungById(Long pruefungId) {
		return pruefungenDAO.loadPruefungById(pruefungId);
	}

	/**
	 * @param pruefungenDAO 
	 */
	public void setPruefungenDAO(PruefungenDAO pruefungenDAO) {
		this.pruefungenDAO = pruefungenDAO;
	}

}