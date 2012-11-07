package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.PruefungsfaecherDAO;
import de.nordakademie.hausarbeit.model.Pruefungsfach;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungsfaecherServiceImpl implements PruefungsfaecherService {
	private PruefungsfaecherDAO pruefungsfaecherDAO;
	
	/**
	 * listPruefungen
	 * 
	 * @return List<Pruefungsfach>
	 */
	public List<Pruefungsfach> listPruefungen() {
		return pruefungsfaecherDAO.loadPruefungsfaecher();
	}

	/**
	 * @param pruefungsfaecherDAO the pruefungsfaecherDAO to set
	 */
	public void setPruefungsfaecherDAO(PruefungsfaecherDAO pruefungsfaecherDAO) {
		this.pruefungsfaecherDAO = pruefungsfaecherDAO;
	}

	/**
	 * @param pruefungsfachId the Id of the Pruefungsfach
	 * @return Pruefungsfach
	 */
	public Pruefungsfach getPruefungsfach(Long pruefungsfachId) {
		return pruefungsfaecherDAO.loadPruefungsfachById(pruefungsfachId);
	}
}