package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Manipel;

/**
 * 
 * @author Niels Maseberg
 */
public class ManipelDAO extends HibernateDaoSupport {
	/**
	 * loadManipel
	 * 
	 * @return List<Manipel>
	 */
	public List<Manipel> loadManipel() {
		return getHibernateTemplate().loadAll(Manipel.class);
	}
}