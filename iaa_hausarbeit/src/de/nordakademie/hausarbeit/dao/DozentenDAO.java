package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
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
	@SuppressWarnings("unchecked")
	public List<Dozent> loadDozenten() {
		return getHibernateTemplate().loadAll(Dozent.class);
	}
	
	/**
	 * loadById
	 * 
	 * @param Long id
	 * @reutrn Dozent
	 */
	public Dozent loadById(Long id) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		try {
			return (Dozent) session.get(Dozent.class, id);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			// TODO: get Logger and log this!!!
		}
		return null;
	}
}
