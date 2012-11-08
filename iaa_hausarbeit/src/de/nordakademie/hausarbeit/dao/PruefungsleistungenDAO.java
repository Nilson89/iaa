package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.model.Studienrichtung;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungsleistungenDAO extends HibernateDaoSupport {
	/**
	 * loadPruefungsleistungenByJahrgangAndStudienrichtung
	 * 
	 * @param Integer the jahrgang
	 * @param Studienrichtung the studienrichtung
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> loadPruefungsleistungenByJahrgangAndStudienrichtung(Integer jahrgang, Studienrichtung studienrichtung) {
		Session session = getSessionFactory().getCurrentSession();
		
		DetachedCriteria letzterVersuch = DetachedCriteria.forClass(Pruefungsleistung.class, "pl2")
				.setProjection( Property.forName("versuch").max() )
				.add( Property.forName("pl2.student").eqProperty("pl.student") )
				.createCriteria("pruefung", "pr2")
				.add( Property.forName("pr2.pruefungsfach").eqProperty("pr.pruefungsfach") );
		
		List<Pruefungsleistung> pruefungsleistungen = session.createCriteria(Pruefungsleistung.class, "pl")
				.add( Property.forName("versuch").eq(letzterVersuch) )
				.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY )
				.createAlias("pruefung", "pr")
				.createCriteria("student", "s")
				.add( Property.forName("s.manipel.pk.jahrgang").eq(jahrgang) )
				.add( Property.forName("s.manipel.pk.studienrichtung").eq(studienrichtung) )
				.createCriteria("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.list();
		
		return pruefungsleistungen;
	}
	
	/**
	 * loadPruefungsleistungenForStudentAndPruefungsfach
	 * 
	 * @param Student the student
	 * @param Pruefungsfach the pruefungsfach
	 * @return List<Pruefungsleistung>
	 */
	public List<Pruefungsleistung> loadPruefungsleistungenForStudentAndPruefungsfach(Student student, Pruefungsfach pruefungsfach) {
		Session session = getSessionFactory().getCurrentSession();
		
		List<Pruefungsleistung> pruefungsleistungen = session.createCriteria(Pruefungsleistung.class, "pl")
				.add( Property.forName("student").eq(student) )
				.createCriteria("pruefung", "pr")
				.add( Property.forName("pr.pruefungsfach").eq(pruefungsfach) )
				.addOrder( Property.forName("pr.datum").asc() )
				.addOrder( Property.forName("pl.erfassungsdatum").asc() )
				.list();
		
		return pruefungsleistungen;
	}
	
	/**
	 * loadPruefungsleistungById
	 * 
	 * @param Long the pruefungsleistungId
	 * @return the Pruefungsleistung
	 */
	public Pruefungsleistung loadPruefungsleistungById(Long pruefungsleistungId) {
		Session session = this.getSessionFactory().getCurrentSession();
		
		try {
			return (Pruefungsleistung) session.get(Pruefungsleistung.class, pruefungsleistungId);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			// TODO: get Logger and log this!!!
		}
		return null;
	}

	/**
	 * savePruefungsleistung
	 * 
	 * @param pruefungsleistung the pruefungsleistung to save
	 */
	public void savePruefungsleistung(Pruefungsleistung pruefungsleistung) {
		getHibernateTemplate().saveOrUpdate(pruefungsleistung);
	}
	
	/**
	 * saveErgaenzungspruefung
	 * 
	 * @param Ergaenzungspruefung the ergaenzungspruefung to save
	 * @return Ergaenzungspruefung
	 */
	public Ergaenzungspruefung saveErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung) {
		getHibernateTemplate().saveOrUpdate(ergaenzungspruefung);
		return ergaenzungspruefung;
	}
}