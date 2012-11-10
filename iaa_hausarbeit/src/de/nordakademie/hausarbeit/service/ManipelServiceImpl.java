package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.ManipelDAO;
import de.nordakademie.hausarbeit.model.Manipel;

/**
 * 
 * @author Niels Maseberg
 */
public class ManipelServiceImpl implements ManipelService {
	private ManipelDAO manipelDAO;
	
	/**
	 * getManipelList
	 * 
	 * @return List<Manipel
	 */
	public List<Manipel> getManipelList() {
		return manipelDAO.loadManipel();
	}

	/**
	 * @param manipelDAO
	 */
	public void setManipelDAO(ManipelDAO manipelDAO) {
		this.manipelDAO = manipelDAO;
	}
}