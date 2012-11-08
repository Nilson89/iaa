package de.nordakademie.hausarbeit.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Niels Maseberg
 */
public class EditPruefungsleistungAction extends ActionSupport {
	private Long selectedPruefungsleistungId;
	private Long selectedPruefungsfachId;

	/**
	 * execute
	 */
	public String execute() throws Exception {
		if (selectedPruefungsleistungId == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * @param selectedPruefungsleistungId the selectedPruefungsleistungId to set
	 */
	public void setSelectedPruefungsleistungId(Long selectedPruefungsleistungId) {
		this.selectedPruefungsleistungId = selectedPruefungsleistungId;
	}

	/**
	 * @return the selectedPruefungsleistungId
	 */
	public Long getSelectedPruefungsleistungId() {
		return selectedPruefungsleistungId;
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
}