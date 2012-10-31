package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Manipel;

/**
 * 
 * @author Niels Maseberg
 */
public class StudentDAO extends HibernateDaoSupport {
	/**
	 * loadMatrikelnummerListByManipel
	 * 
	 * @param Manipel the Manipel to load MatrikelnummerList for
	 * @return List<Integer> the List of Matrikelnummer
	 */
	public List<Integer> loadMatrikelnummerListByManipel(Manipel manipel) {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("select matrikelnummer from Student as student where student.manipel = :manipel").setEntity("manipel", manipel).list();
	}
}