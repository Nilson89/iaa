package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
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
		
		// Detached get Pruefungen of Pruefungsfach
		List<Pruefung> pruefungen = session.createCriteria(Pruefung.class, "pruefungen")
				.add( Restrictions.eq("pruefungsfach", pruefungsfach) )
				.list();
		
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefungsfach.getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria(
						"pruefungsleistungen",
						"pl",
						Criteria.LEFT_JOIN,
						Restrictions.and(
								Restrictions.in("pruefung", pruefungen), // Only Pruefungsleistungen that are in the selected Pruefungsfach
								Restrictions.eq("gueltig", true) // Only Pruefungsleistungen that are valid
						)
				)
				.addOrder( Property.forName("pl.versuch").asc() )
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
		
		// Detached get Pruefungen of Pruefungsfach
		List<Pruefung> pruefungen = session.createCriteria(Pruefung.class, "pruefungen")
				.add( Restrictions.eq("pruefungsfach", pruefung.getPruefungsfach()) )
				.list();
		
		// Last Try of Student in Pruefungsfach that is valid
		DetachedCriteria lastTry = DetachedCriteria.forClass(Pruefungsleistung.class, "plLast")
				.setProjection( Property.forName("versuch").max() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plLast.student").eqProperty("pl.student"))
				.add( Restrictions.in("pruefung", pruefungen) );
		
		// Count of Additional Grades of a Student in a Pruefungsfach
		DetachedCriteria addGradeCount = DetachedCriteria.forClass(Pruefungsleistung.class, "plAddGradeCount")
				.setProjection( Projections.rowCount() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plAddGradeCount.student").eqProperty("pl.student"))
				.add( Restrictions.isNotNull("ergaenzungspruefung") )
				.add( Restrictions.in("pruefung", pruefungen) );		
		
		// ## Main Query ##
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefung.getPruefungsfach().getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria(
						"pruefungsleistungen",
						"pl",
						Criteria.INNER_JOIN,
						Restrictions.and(
								Restrictions.eq("gueltig", true), // Only Grades that are valid
								Restrictions.and(
										Property.forName("versuch").eq(lastTry), // Only the last try of the Pruefungsfach and student
										Restrictions.and(
												Restrictions.isNull("ergaenzungspruefung"), // Only if there is no additional grade
												Restrictions.and(
														Property.forName("note").eq(Note.FUENF), // Only if the last try is a 5.0
														Property.forName("pruefung").eq(pruefung) // Only if the last try was in the selected Pruefung
												)
										)
								)
						)
				)
				.add( Subqueries.gt(Long.valueOf(2), addGradeCount) ) // Only Students that have less then 2 Ergaenzungspruefung
				.list();
		
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
		
		// Detached get Pruefungen of Pruefungsfach
		List<Pruefung> pruefungen = session.createCriteria(Pruefung.class, "pruefungen")
				.add( Restrictions.eq("pruefungsfach", pruefung.getPruefungsfach()) )
				.list();
		
		// Count of exams the student passed in the pruefungsfach
		Note[] passedGrades = {Note.EINS, Note.EINSDREI, Note.EINSSIEBEN, Note.ZWEI, Note.ZWEIDREI, Note.ZWEISIEBEN, Note.DREI, Note.DREIDREI, Note.DREISIEBEN, Note.VIER};
		Note[] passedGradesErgaenzung = {Note.EINS, Note.EINSDREI, Note.EINSSIEBEN, Note.ZWEI};
		DetachedCriteria passedExamCount = DetachedCriteria.forClass(Pruefungsleistung.class, "plPassedGradeCount")
				.setProjection( Projections.rowCount() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plPassedGradeCount.student").eqProperty("pl.student") )
				.createAlias("ergaenzungspruefung", "passedErgaenzung", Criteria.LEFT_JOIN)
				.add( Restrictions.or(
						Restrictions.in("note", passedGrades),
						Restrictions.and(
								Restrictions.eq("note", Note.FUENF),
								Restrictions.in("passedErgaenzung.note", passedGradesErgaenzung)
						)
				) )
				.createCriteria("pruefung", "plPassedLastPruefung")
				.add( Property.forName("pruefungsfach").eq(pruefung.getPruefungsfach()) );
		
		// Get Date of last exam
		DetachedCriteria lastDateCount = DetachedCriteria.forClass(Pruefungsleistung.class, "plLastDate")
				.setProjection( Projections.rowCount() )
				.add( Property.forName("gueltig").eq(true) )
				.add( Property.forName("plLastDate.student").eqProperty("pl.student") )
				.createCriteria("pruefung", "prLastDate")
				.add( Property.forName("datum").gt(pruefung.getDatum()) )
				.add( Property.forName("pruefungsfach").eq(pruefung.getPruefungsfach()) );
		
		// ### Main Query ###
		List<Student> studenten = session.createCriteria(Student.class, "s")
				.add( Property.forName("manipel").eq(pruefung.getPruefungsfach().getManipel()) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.createCriteria(
						"pruefungsleistungen",
						"pl",
						Criteria.LEFT_JOIN,
						Restrictions.and(
								Restrictions.in("pruefung", pruefungen), // Only Pruefungsleistungen that are in the selected Pruefungsfach
								Restrictions.eq("gueltig", true) // Only Pruefungsleistungen that are valid
						)
				)
				.add( Subqueries.gt(Long.valueOf(3), addGradeCount) ) // Only Students that have less then 3 Pruefungsleistungen
				.add( Subqueries.gt(Long.valueOf(1), passedExamCount) ) // Only Student that have not passed the exam yet
				.add( Subqueries.gt(Long.valueOf(1), lastDateCount) ) // Only Students that have not written an exam later
				.add( Restrictions.or(
						Restrictions.ne("pruefung", pruefung), // Only Students that have no grade in the selected Pruefung
						Restrictions.isNull("pruefung")
				) )
				.addOrder( Property.forName("pl.versuch").asc() )
				.list();
		
		
		return studenten;
	}
}