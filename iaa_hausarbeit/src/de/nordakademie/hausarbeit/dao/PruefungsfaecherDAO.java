package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Pruefungsfach;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungsfaecherDAO extends HibernateDaoSupport {
	private static final Logger logger = Logger.getLogger(PruefungsfaecherDAO.class);
	
	/**
	 * loadPruefungsfaecher
	 * 
	 * @return List<Pruefungsfach>
	 */
	@SuppressWarnings("unchecked")
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
			return (Pruefungsfach) session.get(Pruefungsfach.class, id);
		} catch (ObjectNotFoundException e) {
			logger.error("Pruefungsfach with ID '" + id + "' could not be loaded", e);
		}
		return null;
	}
}