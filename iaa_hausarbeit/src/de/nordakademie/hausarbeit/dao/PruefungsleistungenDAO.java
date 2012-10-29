package de.nordakademie.hausarbeit.dao;

import java.util.List;

import org.hibernate.Session;
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
		
		// TODO: Anpassen, sodass nur aktuelle Noten angezeigt werden
		// TODO: Auch Jahrgang und Studienrichtung mit berücksichtigen
		return  session.createQuery("from Pruefungsleistung as pruefungsleistung JOIN Student as student on student.matrikelnummer = pruefungsleistung.studentmatrikelnummer").list();
	}
}