package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
 * @author Sabrina Schramm
 */

public class CreatePruefungsleistungenAction extends ActionSupport {
	private Long selectedPruefungsfachId;
	private Long selectedPruefungId;
	
	private PruefungenService pruefungenService;
	private PruefungsleistungenService pruefungsleistungenService;
	private StudentService studentService;
	private Pruefung pruefung;
	private Pruefungsleistung pruefungleistung;
	private Pruefungsfach pruefungsfach;
	private List<Student> studenten;
	private List<Pruefungsleistung> pruefungsleistungenList = new ArrayList();
	
	private Calendar cal = Calendar.getInstance();
	private Date date = cal.getTime();
	
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		
		// Load Prüfungunsfach and Studenten of Manipel and it´s Noten
		loadPruefungAndStudents();
		
		return SUCCESS;

	}
	
	/**
	 * save
	 */
	public String save() throws Exception {
		for (Pruefungsleistung pruefungsleistung : pruefungsleistungenList) {
			// Get Pruefungsleistung
			pruefungsleistung = pruefungsleistungenService.getPruefungsleistungById(pruefungsleistung.getId());
			
			// Save Pruefungsleistung
			if (!pruefungsleistung.getNote().equals(Note.KeineTeilnahme)) {
				// Create Pruefungsleistung
				pruefungsleistung.setErfassungsdatum(date);
				
				pruefungsleistung = pruefungsleistungenService.createPruefungsleistung(pruefungsleistung);
				
				// Update Pruefungsleistung
				pruefungsleistungenService.createPruefungsleistung(pruefungsleistung);
			}
			
			// Add Pruefungsleistung to List of new Pruefungsleistungen
			pruefungsleistungenList.add(pruefungsleistung);
		}
		
		return SUCCESS;
	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		if (getSelectedPruefungId() == null) {
			addActionError(getText("error.no.pruefung.selected"));
		} else {
			// Load Data
			loadPruefungAndStudents();
		}
	}
	
	/**
	 * loadPruefungAndStudents
	 */
	private void loadPruefungAndStudents() {

		// Load Pruefung
		pruefung = pruefungenService.getPruefungById(selectedPruefungId);
		System.out.println("Prüfung wurde geladen: " + pruefung.getId());
		
		// Load Studenten of Manipel and it´s Noten
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefungsfach(pruefung.getPruefungsfach());

	}

	/**
	 * @return the pruefungsfach
	 */
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}

	/**
	 * @param studentService the studentService to set
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @return the studenten
	 */
	public List<Student> getStudenten() {
		return studenten;
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


	public Long getSelectedPruefungId() {
		return selectedPruefungId;
	}

	public void setSelectedPruefungId(Long selectedPruefungId) {
		this.selectedPruefungId = selectedPruefungId;
	}	
	
	/**
	 * @return the pruefung
	 */
	public Pruefung getPruefung() {
		return pruefung;
	}

	/**
	 * @param pruefungenService the pruefungenService to set
	 */
	public void setPruefungenService(PruefungenService pruefungenService) {
		this.pruefungenService = pruefungenService;
	}

	/**
	 * @return the ergaenzungspruefungenList
	 */
	public List<Pruefungsleistung> getPruefungsleistungenList() {
		return pruefungsleistungenList;
	}

	/**
	 * @param ergaenzungspruefungenList the ergaenzungspruefungenList to set
	 */
	public void setPruefungsleistungenList(
			List<Pruefungsleistung> pruefungsleistungenList) {
		this.pruefungsleistungenList = pruefungsleistungenList;
	}

}
