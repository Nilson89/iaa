package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Dozent;

/**
 * 
 * @author Sabrina Schramm
 */

public class DozentenDAO extends HibernateDaoSupport{
	/**
	 * loadDozenten
	 * 
	 * @return List<Dozent>
	 */
	public List<Dozent> loadDozenten() {
		return getHibernateTemplate().loadAll(Dozent.class);
	}
}
