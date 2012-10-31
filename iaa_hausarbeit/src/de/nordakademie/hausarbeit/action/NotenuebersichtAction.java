package de.nordakademie.hausarbeit.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Studienrichtung;
import de.nordakademie.hausarbeit.service.ManipelService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;

/**
 * 
 * @author Niels Maseberg
 */
public class NotenuebersichtAction extends ActionSupport {
	private ManipelService manipelService;
	private PruefungsleistungenService pruefungsleistungenService;
	private static final Logger logger = Logger.getLogger(PruefungslistAction.class);
	
	private String selectedManipel = "none";
	
	private List<Manipel> manipelList;
	private List<Pruefungsleistung> noten;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load the List of all Manipel
		_loadManipelList();
		
		return SUCCESS;
	}
	
	/**
	 * showDetail
	 */
	public String showDetail() throws Exception {
		// Get selectedManipel and split in jahrgang and studienrichtung
		int jahrgang = Integer.parseInt(selectedManipel.substring(1));
		String studienrichtungTemp = (String) selectedManipel.subSequence(0, 1);
		Studienrichtung studienrichtung = Studienrichtung.valueOf(studienrichtungTemp);
		
		// Load Noten
		noten = pruefungsleistungenService.listNoten(jahrgang, studienrichtung);
		
		return SUCCESS;
	}

	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Load the List of all Manipel
		_loadManipelList();
		
		// If no Manipel is selected, then show Error
		if (getSelectedManipel().equals("none")) {
			addFieldError("selectedManipel", getText("error.no.manipel.selected"));
		}
	}

	/**
	 * @param manipelService the manipelService to set
	 */
	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	/**
	 * @return the manipelList
	 */
	public List<Manipel> getManipelList() {
		return manipelList;
	}

	/**
	 * @param selectedManipel the selectedManipel to set
	 */
	public void setSelectedManipel(String selectedManipel) {
		this.selectedManipel = selectedManipel;
	}

	/**
	 * @return the selectedManipel
	 */
	public String getSelectedManipel() {
		return selectedManipel;
	}
	
	/**
	 * loadManipelList
	 */
	private void _loadManipelList() {
		manipelList = manipelService.getManipelList();
	}

	/**
	 * @param pruefungsleistungenService the pruefungsleistungenService to set
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
	}

	/**
	 * @return the noten
	 */
	public List<Pruefungsleistung> getNoten() {
		return noten;
	}
}