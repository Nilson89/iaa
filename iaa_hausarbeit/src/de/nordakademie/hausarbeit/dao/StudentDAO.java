package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
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
	
	/**
	 * getStudentenByManipelAndPruefungsleistungenByPruefungsfach
	 * 
	 * @param Pruefungsfach the pruefungsfach
	 * @return List<Student>
	 */
	public List<Student> getStudentenByManipelAndPruefungsleistungenByPruefungsfach(Pruefungsfach pruefungsfach) {
		Session session = this.getSessionFactory().getCurrentSession();
		//session.enableFetchProfile("student-with-pruefungsleistungen"); // Enable fetchProfile to deactivate lazyLoading
		
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefungsfach.getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria("pruefungsleistungen", "pl", Criteria.LEFT_JOIN)
				.add( Restrictions.or(
						Restrictions.eq("gueltig", true),
						Restrictions.isNull("gueltig")
				) )
				.addOrder( Property.forName("pl.versuch").asc() )
				.createCriteria("pruefung", "pr", Criteria.LEFT_JOIN)
				.add( Restrictions.or(
						Restrictions.eq("pr.pruefungsfach", pruefungsfach),
						Restrictions.isNull("pr.pruefungsfach")
				) )
				.list();
		
		//session.disableFetchProfile("student-with-pruefungsleistungen");
		
		return studenten;
	}
}