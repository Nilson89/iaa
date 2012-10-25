package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Pruefung;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungenDAO extends HibernateDaoSupport {
	/**
	 * loadPruefungen
	 * 
	 * @param pruefungsfachId the Id of the pruefungsfach
	 * @return List<Pruefung>
	 */
	public List<Pruefung> loadPruefungen(Long pruefungsfachId) {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("from Pruefung as pruefung WHERE pruefung.pruefungsfach.id = :pruefungsfachId").setLong("pruefungsfachId", pruefungsfachId).list();
	}
}