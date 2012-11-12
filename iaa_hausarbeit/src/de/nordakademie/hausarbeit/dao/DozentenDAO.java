package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
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
		Session session = this.getSessionFactory().getCurrentSession();
		
		List<Dozent> dozenten = session.createCriteria(Dozent.class)
				.createCriteria("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.list();
		
		return dozenten;
	}
	
	/**
	 * loadById
	 * 
	 * @param id
	 * @return Dozent
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
