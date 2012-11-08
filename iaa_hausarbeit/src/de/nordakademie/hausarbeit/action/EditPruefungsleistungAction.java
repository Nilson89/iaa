package de.nordakademie.hausarbeit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Niels Maseberg
 */
public class EditPruefungsleistungAction extends ActionSupport {
	private Long selectedPruefungsleistungId;
	private Long selectedPruefungsfachId;
	private static final Logger logger = Logger.getLogger(EditPruefungsleistungAction.class);

	/**
	 * execute
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Log selected Matrikelnummer
		if(logger.isDebugEnabled()){
			logger.debug("EditPruefungsleistungAction: Pruefungsfach mit ID '" + selectedPruefungsfachId + "' selected");
		}
		
		// If no Manipel is selected, then show Error
		if (selectedPruefungsleistungId == null) {
			addActionError("txtErrorNoPruefungsleistungSelected");
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
	 * @param selectedPruefungsfachId the selectedPruefungsfachId to set
	 */
	public void setSelectedPruefungsfachId(Long selectedPruefungsfachId) {
		this.selectedPruefungsfachId = selectedPruefungsfachId;
	}
	
	/**
	 * @return the selectedPruefungsfachId
	 */
	public Long getSelectedPruefungsfachId() {
		return selectedPruefungsfachId;
	}
}