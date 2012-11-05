package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Student;

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
		return session.createQuery("select matrikelnummer from Student as student where student.manipel = :manipel order by matrikelnummer asc").setEntity("manipel", manipel).list();
	}
	
	/**
	 * loadStudent
	 * 
	 * @param Integer the matrikelnummer
	 * @return Student the student
	 */
	public Student loadStudent(Integer matrikelnummer) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		try {
			return (Student) session.get(Student.class, matrikelnummer);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			// TODO: get Logger and log this!!!
		}
		return null;
	}
}