package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.ManipelDAO;
import de.nordakademie.hausarbeit.model.Manipel;

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
	 * @param manipelDAO the manipelDAO to set
	 */
	public void setManipelDAO(ManipelDAO manipelDAO) {
		this.manipelDAO = manipelDAO;
	}
}