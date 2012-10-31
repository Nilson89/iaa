package de.nordakademie.hausarbeit.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Dozent;
import de.nordakademie.hausarbeit.service.DozentenService;


/**
 * 
 * @author Sabrina Schramm
 */

public class CreatePruefungAction extends ActionSupport {
	private DozentenService dozentenService;
	
	private String selectedDozent = "none";
	
	private List<Dozent> dozentenList;
		
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load the List of all Dozenten
		loadDozentenList();
				
		return SUCCESS;
	}
	

	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Load the List of all Dozenten
		loadDozentenList();
		
		// If no Dozent is selected, then show Error
		if (getSelectedDozent().equals("none")) {
			addFieldError("selectedDozent", getText("error.no.dozent.selected"));
		}
	}

	/**
	 * @param dozentenService the dozentenService to set
	 */
	public void setDozentenService(DozentenService dozentenService) {
		this.dozentenService = dozentenService;
	}

	/**
	 * @return the dozentenList
	 */
	public List<Dozent> getDozentenList() {
		return dozentenList;
	}

	/**
	 * @param selectedDozent the selectedDozent to set
	 */
	public void setSelectedDozent(String selectedDozent) {
		this.selectedDozent = selectedDozent;
	}

	/**
	 * @return the selectedDozent
	 */
	public String getSelectedDozent() {
		return selectedDozent;
	}
	
	/**
	 * loadDozentenList
	 */
	private void loadDozentenList() {
		dozentenList = dozentenService.getDozentenList();
	}
	
}
