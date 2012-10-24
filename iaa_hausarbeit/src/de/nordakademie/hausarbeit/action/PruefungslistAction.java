package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.service.PruefungenService;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungslistAction implements Action {
	private PruefungenService pruefungenService;
	private Long selectedPruefungsfachId;
	private List<Pruefung> pruefungen;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		pruefungen = pruefungenService.listPruefungen(selectedPruefungsfachId);
		return SUCCESS;
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

}
