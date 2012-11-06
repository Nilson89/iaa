package de.nordakademie.hausarbeit.service;

import java.util.List; 

import de.nordakademie.hausarbeit.dao.DozentenDAO;
import de.nordakademie.hausarbeit.model.Dozent;

/**
 * 
 * @author Sabrina Schramm und Niels Maseberg
 */

public class DozentenServiceImpl implements DozentenService {
	private DozentenDAO dozentenDAO;
	
	/**
	 * getDozentenList
	 * 
	 * @return List<Dozent>
	 */
	public List<Dozent> getDozentenList() {
		return dozentenDAO.loadDozenten();
	}

	/**
	 * getById
	 * 
	 * @param Long id
	 * @return Dozent
	 */
	public Dozent getById(Long id) {
		return dozentenDAO.loadById(id);
	}

	/**
	 * @param manipelDAO the manipelDAO to set
	 */
	public void setDozentenDAO(DozentenDAO dozentenDAO) {
		this.dozentenDAO = dozentenDAO;
	}

}
