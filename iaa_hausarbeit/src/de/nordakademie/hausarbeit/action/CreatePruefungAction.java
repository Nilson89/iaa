package de.nordakademie.hausarbeit.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Dozent;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.DozentenService;
import de.nordakademie.hausarbeit.service.PruefungenService;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;


/**
 * 
 * @author Sabrina Schramm
 */

public class CreatePruefungAction extends ActionSupport {
	private DozentenService dozentenService;
	private Pruefung pruefung;
	private PruefungenService pruefungenService;
	private PruefungsfaecherService pruefungsfaecherService;
	
	private Long selectedPruefungsfachId;
	private Date selectedDatum = new Date();
	private String selectedDozent = "none";
	private Pruefungsfach pruefungsfach;
	private List<Dozent> dozentenList;
		
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load the List of all Dozenten
		loadDozentenList();
		
		// Load gewähltes Prüfungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
				
		return SUCCESS;
	}
	
	/**
	 * savePruefung
	 */
	public String savePruefung() throws Exception {
		// Create Pruefung-Object
		Long dozentId = Long.valueOf(selectedDozent).longValue();
		
		pruefung = new Pruefung();
		pruefung.setDatum(selectedDatum);
		pruefung.setDozent(dozentenService.getById(dozentId));
		pruefung.setPruefungsfach(pruefungsfach);
		
		// Store Pruefung in Database
		pruefungenService.savePruefung(pruefung);
		return SUCCESS;
	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Load the List of all Dozenten
		loadDozentenList();
		
		// Load gewähltes Prüfungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
		
		// If no Dozent is selected, then show Error
		if (getSelectedDozent().equals("none")) {
			addFieldError("selectedDozent", getText("error.no.dozent.selected"));
		}
		
		if (getSelectedDatum() == null) {
			addFieldError("selectedDatum", getText("error.no.datum.entered"));
		}
		
		// If Pruefung already exists
		// TODO
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


	public void setPruefungenService(PruefungenService pruefungenService) {
		this.pruefungenService = pruefungenService;
	}

	/**
	 * @param pruefungsfaecherService the pruefungsfaecherService to set
	 */
	public void setPruefungsfaecherService(PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}

	/**
	 * @return the pruefungsfach
	 */
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}

	/**
	 * @return the selectedDatum
	 */
	public Date getSelectedDatum() {
		return selectedDatum;
	}

	/**
	 * @param selectedDatum the selectedDatum to set
	 */
	public void setSelectedDatum(Date selectedDatum) {
		this.selectedDatum = selectedDatum;
	}

}
