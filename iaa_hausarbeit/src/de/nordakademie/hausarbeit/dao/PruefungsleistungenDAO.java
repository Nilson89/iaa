package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nordakademie.hausarbeit.model.Pruefungsleistung;
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
				.createAlias("pruefung", "pr")
				.createCriteria("student", "s")
				.add( Property.forName("s.manipel.pk.jahrgang").eq(jahrgang) )
				.add( Property.forName("s.manipel.pk.studienrichtung").eq(studienrichtung) )
				.createCriteria("person", "p")
				.addOrder( Property.forName("p.name").asc() )
				.list();
		
		return pruefungsleistungen;
	}
}