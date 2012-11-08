package de.nordakademie.hausarbeit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Pruefung;

/**
 * 
 * @author Niels Maseberg, Sabrina Schramm
 */
public class PruefungenDAO extends HibernateDaoSupport {
	/**
	 * loadPruefungen
	 * 
	 * @param pruefungsfachId the Id of the pruefungsfach
	 * @return List<Pruefung>
	 */
	@SuppressWarnings("unchecked")
	public List<Pruefung> loadPruefungen(Long pruefungsfachId) {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("from Pruefung as pruefung WHERE pruefung.pruefungsfach.id = :pruefungsfachId").setLong("pruefungsfachId", pruefungsfachId).list();
	}
	
	/**
	 * saveOrUpdatePruefung
	 * create/update -> saveOrUpdate
	 * 
	 * @param pruefung
	 * @return pruefung
	 */
	public Pruefung saveOrUpdatePruefung(Pruefung pruefung) {
		getHibernateTemplate().saveOrUpdate(pruefung);
		return pruefung;
	}
	
	/**
	 * checkPruefungByPruefungsfachAndDateAndDozent
	 * 
	 * Returns
	 * 	true if the pruefung already exists
	 *  false otherwise
	 * 
	 * @param Long the id of the pruefungsfach
	 * @param Date the date
	 * @param Long the id of the dozent
	 * @return Pruefung
	 */
	public boolean checkPruefungByPruefungsfachAndDateAndDozent(Long pruefungsfachId, Date datum, Long dozentId) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		Long resultCount = (Long) session.createQuery("select count(*) from Pruefung as pruefung where pruefung.datum = :datum and pruefung.pruefungsfach.id = :pruefungsfachId and pruefung.dozent.id = :dozentId")
				.setDate("datum", datum)
				.setLong("pruefungsfachId", pruefungsfachId)
				.setLong("dozentId", dozentId)
				.uniqueResult();
		if (resultCount > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * loadPruefungById
	 * 
	 * @param Long pruefungId
	 * @return Pruefung
	 */
	public Pruefung loadPruefungById(Long pruefungId) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		try {
			return (Pruefung) session.get(Pruefung.class, pruefungId);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			// TODO: get Logger and log this!!!
		}
		return null;
	}
}