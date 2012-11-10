package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg
 */
public class StudentDAO extends HibernateDaoSupport {
	/**
	 * loadMatrikelnummerListByManipel
	 * 
	 * @param manipel 
	 * @return List<Matrikelnummer> 
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> loadMatrikelnummerListByManipel(Manipel manipel) {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("select matrikelnummer from Student as student where student.manipel = :manipel order by matrikelnummer asc").setEntity("manipel", manipel).list();
	}
	
	/**
	 * loadStudent
	 * 
	 * @param matrikelnummer
	 * @return student
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
	 * @param pruefungsfach
	 * @return List<Student>
	 */
	@SuppressWarnings("unchecked")
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
	
	/**
	 * getStudentenByManipelAndPruefungsleistungenByPruefung
	 * 
	 * @param pruefung
	 * @return List<Student>
	 */
	@SuppressWarnings("unchecked")
	public List<Student> getStudentenByManipelAndPruefungsleistungenByPruefung(Pruefung pruefung) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		// Last Try of Student in Pruefungsfach that is valid
		DetachedCriteria lastTry = DetachedCriteria.forClass(Pruefungsleistung.class, "plLast")
				.setProjection( Property.forName("versuch").max() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plLast.student").eqProperty("pl.student"))
				.createCriteria("pruefung", "plLastPruefung")
				.add( Property.forName("pruefungsfach").eq(pruefung.getPruefungsfach()) );
		
		// Count of Additional Grades of a Student in a Pruefungsfach
		DetachedCriteria addGradeCount = DetachedCriteria.forClass(Pruefungsleistung.class, "plAddGradeCount")
				.setProjection( Projections.rowCount() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plAddGradeCount.student").eqProperty("pl.student"))
				.add( Restrictions.isNotNull("ergaenzungspruefung") )
				.createCriteria("pruefung", "plLastPruefung")
				.add( Property.forName("pruefungsfach").eq(pruefung.getPruefungsfach()) );		
		
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefung.getPruefungsfach().getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria("pruefungsleistungen", "pl")
				.add( Restrictions.eq("gueltig", true) ) // Only Grades that are valid
				.add( Property.forName("versuch").eq(lastTry) ) // Only the last try of the Pruefungsfach and student
				.add( Restrictions.isNull("ergaenzungspruefung") ) // Only if there is no additional grade
				.add( Property.forName("note").eq(Note.FUENF) ) // Only if the last try is a 5.0
				.add( Property.forName("pruefung").eq(pruefung) ) // Only if the last try was in the selected Pruefung
				.add( Subqueries.gt(Long.valueOf(2), addGradeCount) ) // Only Students that have less then 2 Ergaenzungspruefung
				.list();
		
		// TODO: Nur die Prüfungsleistungen berücksichtigen, die im gewählten Prüfungsfach sind
		
		return studenten;
	}
	
	/**
	 * getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung
	 * 
	 * @param pruefung
	 * @return List<Student>
	 */
	@SuppressWarnings("unchecked")
	public List<Student> getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung(Pruefung pruefung) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		// Count of Grades of a Student in a Pruefungsfach
		DetachedCriteria addGradeCount = DetachedCriteria.forClass(Pruefungsleistung.class, "plAddGradeCount")
				.setProjection( Projections.rowCount() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plAddGradeCount.student").eqProperty("pl.student"))
				.createCriteria("pruefung", "plLastPruefung")
				.add( Property.forName("pruefungsfach").eq(pruefung.getPruefungsfach()) );
		
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefung.getPruefungsfach().getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria("pruefungsleistungen", "pl", Criteria.LEFT_JOIN)
				.add( Restrictions.or(
						Restrictions.eq("gueltig", true), // Only grades that are valid
						Restrictions.isNull("gueltig")
				) )
				.add( Subqueries.gt(Long.valueOf(3), addGradeCount) ) // Only Students that have less then 2 Pruefungsleistungen
				.add( Restrictions.or(
						Restrictions.ne("pruefung", pruefung), // Only Students that have no grade in the selected Pruefung
						Restrictions.isNull("pruefung")
				) )
				.addOrder( Property.forName("pl.versuch").asc() )
				.createCriteria("pruefung", "pr", Criteria.LEFT_JOIN)
				.add( Restrictions.or(
						Restrictions.eq("pr.pruefungsfach", pruefung.getPruefungsfach()),
						Restrictions.isNull("pr.pruefungsfach")
				) )
				.list();
		
		return studenten;
	}
}