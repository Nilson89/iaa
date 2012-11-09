package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungenService;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;
import de.nordakademie.hausarbeit.service.StudentService;


/**
 * 
 * @author Niels Maseberg
 */

public class CreateMdlPruefungsleistungenAction extends ActionSupport {
	private Long selectedPruefungId;
	private PruefungenService pruefungenService;
	private Pruefung pruefung;
	private List<Student> studenten;
	private StudentService studentService;
	private PruefungsleistungenService pruefungsleistungenService;
	
	private List<Ergaenzungspruefung> ergaenzungspruefungenList = new ArrayList();
	private List<Pruefungsleistung> newPruefungsleistungenList = new ArrayList();
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		loadPruefungAndStudents();
		
		return SUCCESS;
	}
	
	/**
	 * save
	 */
	public String save() throws Exception {
		for (Ergaenzungspruefung ergaenzungspruefung : ergaenzungspruefungenList) {
			// Get Pruefungsleistung
			Pruefungsleistung pruefungsleistung = pruefungsleistungenService.getPruefungsleistungById(ergaenzungspruefung.getPruefungsleistungId());
			pruefungsleistung.setErgaenzungspruefung(ergaenzungspruefung);
			
			// Save Ergaenzungspruefung
			if (!ergaenzungspruefung.getNote().equals(Note.KeineTeilnahme)) {
				// Create Ergaenzungspruefung
				ergaenzungspruefung.setErfassungsdatum(new Date());
				ergaenzungspruefung = pruefungsleistungenService.createErgaenzungspruefung(ergaenzungspruefung);
				
				// Update Pruefungsleistung
				pruefungsleistung.setErgaenzungspruefung(ergaenzungspruefung);
				pruefungsleistungenService.createPruefungsleistung(pruefungsleistung);
			}
			
			// Add Ergaenzungspruefung to List of new Ergaenzungspruefungen
			newPruefungsleistungenList.add(pruefungsleistung);
		}
		
		return SUCCESS;
	}

	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Load Data
		loadPruefungAndStudents();
	}
	
	/**
	 * loadPruefungAndStudents
	 */
	private void loadPruefungAndStudents() {
		// Load Pruefung
		pruefung = pruefungenService.getPruefungById(selectedPruefungId);
		
		// Load Studenten and its grades
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefung(pruefung);
	}

	/**
	 * @return the pruefung
	 */
	public Pruefung getPruefung() {
		return pruefung;
	}

	/**
	 * @param selectedPruefungId the selectedPruefungId to set
	 */
	public void setSelectedPruefungId(Long selectedPruefungId) {
		this.selectedPruefungId = selectedPruefungId;
	}

	/**
	 * @param pruefungenService the pruefungenService to set
	 */
	public void setPruefungenService(PruefungenService pruefungenService) {
		this.pruefungenService = pruefungenService;
	}

	/**
	 * @return the studenten
	 */
	public List<Student> getStudenten() {
		return studenten;
	}

	/**
	 * @param studentService the studentService to set
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @return the ergaenzungspruefungenList
	 */
	public List<Ergaenzungspruefung> getErgaenzungspruefungenList() {
		return ergaenzungspruefungenList;
	}

	/**
	 * @param ergaenzungspruefungenList the ergaenzungspruefungenList to set
	 */
	public void setErgaenzungspruefungenList(
			List<Ergaenzungspruefung> ergaenzungspruefungenList) {
		this.ergaenzungspruefungenList = ergaenzungspruefungenList;
	}

	/**
	 * @param pruefungsleistungenService the pruefungsleistungenService to set
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
	}

	/**
	 * @return the newPruefungsleistungenList
	 */
	public List<Pruefungsleistung> getNewPruefungsleistungenList() {
		return newPruefungsleistungenList;
	}
}