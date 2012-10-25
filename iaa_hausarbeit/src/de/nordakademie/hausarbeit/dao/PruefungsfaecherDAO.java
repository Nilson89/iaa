package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
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
	
	/**
	 * loadPruefungsfachById
	 * 
	 * @param id
	 * @return Pruefungsfach
	 */
	public Pruefungsfach loadPruefungsfachById(Long id) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		try {
			return (Pruefungsfach) session.load(Pruefungsfach.class, id);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			// TODO: get Logger and log this!!!
		}
		return null;
	}
}