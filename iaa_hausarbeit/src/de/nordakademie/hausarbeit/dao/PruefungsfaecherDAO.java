package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Pruefungsfach;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungsfaecherDAO extends HibernateDaoSupport {
	/**
	 * loadPruefungsfaecher
	 * 
	 * @return List<Pruefungsfach>
	 */
	public List<Pruefungsfach> loadPruefungsfaecher() {
		return getHibernateTemplate().loadAll(Pruefungsfach.class);
	}
}
