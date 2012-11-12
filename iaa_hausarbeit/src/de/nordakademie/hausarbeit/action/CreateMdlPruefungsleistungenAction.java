package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungenService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;
import de.nordakademie.hausarbeit.service.StudentService;


/**
 * 
 * @author Niels Maseberg
 */

public class CreateMdlPruefungsleistungenAction extends ActionSupport {
	private Long selectedPruefungId;
	private Long selectedPruefungsfachId;
	private PruefungenService pruefungenService;
	private Pruefung pruefung;
	private List<Student> studenten;
	private StudentService studentService;
	private PruefungsleistungenService pruefungsleistungenService;
	
	private List<Ergaenzungspruefung> ergaenzungspruefungenList = new ArrayList<Ergaenzungspruefung>();
	private List<Pruefungsleistung> newPruefungsleistungenList = new ArrayList<Pruefungsleistung>();
	
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
			
			System.out.println("Ergaenzungspruefung found");
			System.out.println("with pruefungsleistungId: " + ergaenzungspruefung.getPruefungsleistungId());
			System.out.println("with erfassungsdatum: " + ergaenzungspruefung.getErfassungsdatum());
			System.out.println("with note: " + ergaenzungspruefung.getNote());
			
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
		
		// Load Studenten and its grades
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefung(pruefung);
	}

	/**
	 * @return pruefung
	 */
	public Pruefung getPruefung() {
		return pruefung;
	}

	/**
	 * @param selectedPruefungId 
	 */
	public void setSelectedPruefungId(Long selectedPruefungId) {
		this.selectedPruefungId = selectedPruefungId;
	}

	/**
	 * @param pruefungenService 
	 */
	public void setPruefungenService(PruefungenService pruefungenService) {
		this.pruefungenService = pruefungenService;
	}

	/**
	 * @return studenten
	 */
	public List<Student> getStudenten() {
		return studenten;
	}

	/**
	 * @param studentService 
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @return ergaenzungspruefungenList
	 */
	public List<Ergaenzungspruefung> getErgaenzungspruefungenList() {
		return ergaenzungspruefungenList;
	}

	/**
	 * @param ergaenzungspruefungenList 
	 */
	public void setErgaenzungspruefungenList(
			List<Ergaenzungspruefung> ergaenzungspruefungenList) {
		this.ergaenzungspruefungenList = ergaenzungspruefungenList;
	}

	/**
	 * @param pruefungsleistungenService 
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
	}

	/**
	 * @return newPruefungsleistungenList
	 */
	public List<Pruefungsleistung> getNewPruefungsleistungenList() {
		return newPruefungsleistungenList;
	}

	/**
	 * @return selectedPruefungId
	 */
	public Long getSelectedPruefungId() {
		return selectedPruefungId;
	}

	/**
	 * @return selectedPruefungsfachId
	 */
	public Long getSelectedPruefungsfachId() {
		return selectedPruefungsfachId;
	}

	/**
	 * @param selectedPruefungsfachId 
	 */
	public void setSelectedPruefungsfachId(Long selectedPruefungsfachId) {
		this.selectedPruefungsfachId = selectedPruefungsfachId;
	}
}