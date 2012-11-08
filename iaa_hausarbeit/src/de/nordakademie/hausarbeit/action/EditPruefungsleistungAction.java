package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;

/**
 * 
 * @author Niels Maseberg
 */
public class EditPruefungsleistungAction extends ActionSupport {
	private Long selectedPruefungsleistungId;
	private Long selectedPruefungsfachId;
	private static final Logger logger = Logger.getLogger(EditPruefungsleistungAction.class);
	private PruefungsleistungenService pruefungsleistungenService;
	private PruefungsfaecherService pruefungsfaecherService;
	private Pruefungsfach pruefungsfach;
	private Pruefungsleistung pruefungsleistung;
	private String selectedNote;

	/**
	 * execute
	 */
	public String execute() throws Exception { 
		return SUCCESS;
	}
	
	/**
	 * save
	 */
	public String save() throws Exception {
		// Mark pruefungsleistung as "ungueltig"
		pruefungsleistungenService.markPruefungsleistungAsInvalid(pruefungsleistung);
		
		// Create new Pruefungsleistung and save it
		Pruefungsleistung newPruefungsleistung = new Pruefungsleistung();
		newPruefungsleistung.setVersuch(pruefungsleistung.getVersuch());
		newPruefungsleistung.setNote(Note.getEnum(selectedNote));
		if (newPruefungsleistung.getNote().equals(Note.FUENF)) {
			newPruefungsleistung.setMdl_moeglich(true);
		} else {
			newPruefungsleistung.setMdl_moeglich(false);
		}
		newPruefungsleistung.setErfassungsdatum(new Date());
		newPruefungsleistung.setPruefung(pruefungsleistung.getPruefung());
		newPruefungsleistung.setStudent(pruefungsleistung.getStudent());
		newPruefungsleistung.setErfasser(pruefungsleistung.getErfasser());
		newPruefungsleistung.setAenderungseintrag(true);
		pruefungsleistungenService.createPruefungsleistung(newPruefungsleistung);
		
		return SUCCESS;
	}
	
	/**
	 * reverse
	 */
	public String reverse() throws Exception {
		// TODO
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
		
		// Load Pruefungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
		
		// If no Pruefungsleistung is selected, then show Error
		if (selectedPruefungsleistungId == null) {
			addActionError("txtErrorNoPruefungsleistungSelected");
		} else {
			// Load Pruefungsleistung
			pruefungsleistung = pruefungsleistungenService.getPruefungsleistungById(selectedPruefungsleistungId);
		}
		
		// If no new Grade is selected
		if (getSelectedNote() != null) {
			if (getSelectedNote().equals("none")) {
				addFieldError("selectedNote", getText("error.no.new.grade.selected"));
			}
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

	/**
	 * @param pruefungsleistungenService the pruefungsleistungenService to set
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
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

	/**
	 * @return the pruefungsleistung
	 */
	public Pruefungsleistung getPruefungsleistung() {
		return pruefungsleistung;
	}
	
	/**
	 * getNoteList
	 * 
	 * @return List<Note>
	 */
	public List<Note> getNoteList() {
		List<Note> values = new ArrayList<Note>();
		
		for (Note note : Note.values()) {
			if (!note.toString().equals("nicht teilgenommen")) {
				values.add(note);
			}
		}
		
		return values;
	}

	/**
	 * @return the selectedNote
	 */
	public String getSelectedNote() {
		return selectedNote;
	}

	/**
	 * @param selectedNote the selectedNote to set
	 */
	public void setSelectedNote(String selectedNote) {
		this.selectedNote = selectedNote;
	}
}