package de.nordakademie.hausarbeit.service;

import de.nordakademie.hausarbeit.dao.PruefungsfaecherDAO;

public class PruefungsfaecherServiceImpl implements PruefungsfaecherService {
	private PruefungsfaecherDAO pruefungsfaecherDAO;

	/**
	 * @param pruefungsfaecherDAO the pruefungsfaecherDAO to set
	 */
	public void setPruefungsfaecherDAO(PruefungsfaecherDAO pruefungsfaecherDAO) {
		this.pruefungsfaecherDAO = pruefungsfaecherDAO;
	}
}
