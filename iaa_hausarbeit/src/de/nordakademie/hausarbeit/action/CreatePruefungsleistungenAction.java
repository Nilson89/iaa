package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;


/**
 * 
 * @author Sabrina Schramm
 */

public class CreatePruefungsleistungenAction extends ActionSupport {

	private PruefungsfaecherService pruefungsfaecherService;
	
	private Long selectedPruefungsfachId;
	private String selectedNote = "none";
	private Pruefungsfach pruefungsfach;
	private List<Note> notenList;
		
	/**
	 * execute
	 */
	public String execute() throws Exception {
		
		// Load gewähltes Prüfungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
				
		return SUCCESS;
	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// If no Note is selected, then show Error
		if (getSelectedNote().equals("none")) {
			addFieldError("selectedNote", getText("error.no.note.selected"));
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
	 * @return the notenList
	 */
	public List<Note> getNotenList() {
		return notenList;
	}

	/**
	 * @param selectedNote the selectedNote to set
	 */
	public void setSelectedNote(String selectedNote) {
		this.selectedNote = selectedNote;
	}

	/**
	 * @return the selectedNote
	 */
	public String getSelectedNote() {
		return selectedNote;
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
	

}
