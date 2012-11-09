package de.nordakademie.hausarbeit.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.PruefungenService;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungslistAction extends ActionSupport {
	private PruefungenService pruefungenService;
	private PruefungsfaecherService pruefungsfaecherService;
	
	private Long selectedPruefungsfachId;
	private List<Pruefung> pruefungen;
	private Pruefungsfach pruefungsfach;
	private static final Logger logger = Logger.getLogger(PruefungslistAction.class);
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Logging selectedPruefungsfachId
		if(logger.isDebugEnabled()){
			logger.debug("Pruefungsfach mit der ID '" + selectedPruefungsfachId + "' wurde gewählt");
		}
		
		// Load Pruefungen für das gewählte Prüfungsfach
		pruefungen = pruefungenService.listPruefungen(selectedPruefungsfachId);
		
		// Load gewähltes Prüfungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
		if(logger.isDebugEnabled()){
			logger.debug("Pruefungsfach mit der ID '" + pruefungsfach.getId() + "' wurde geladen");
		}
		
		return SUCCESS;
	}

	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		if (getSelectedPruefungsfachId() == null) {
			addActionError(getText(""));
		}
	}

	/**
	 * @return the selectedPruefungsfachId
	 */
	public Long getSelectedPruefungsfachId() {
		return selectedPruefungsfachId;
	}

	/**
	 * @param selectedPruefungsfachId the selectedPruefungsfachId to set
	 */
	public void setSelectedPruefungsfachId(Long selectedPruefungsfachId) {
		this.selectedPruefungsfachId = selectedPruefungsfachId;
	}

	/**
	 * @return the pruefungen
	 */
	public List<Pruefung> getPruefungen() {
		return pruefungen;
	}

	/**
	 * @param pruefungenService the pruefungenService to set
	 */
	public void setPruefungenService(PruefungenService pruefungenService) {
		this.pruefungenService = pruefungenService;
	}

	/**
	 * @param pruefungsfaecherService the pruefungsfaecherService to set
	 */
	public void setPruefungsfaecherService(
			PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}

	/**
	 * @return the pruefungsfach
	 */
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}

}