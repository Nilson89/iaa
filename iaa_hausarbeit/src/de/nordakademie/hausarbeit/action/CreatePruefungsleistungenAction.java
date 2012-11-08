package de.nordakademie.hausarbeit.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;
import de.nordakademie.hausarbeit.service.StudentService;


/**
 * 
 * @author Sabrina Schramm
 */

public class CreatePruefungsleistungenAction extends ActionSupport {
	private Long selectedPruefungsfachId;
	private Long selectedPruefungId = null;
	
	private PruefungsfaecherService pruefungsfaecherService;
	private StudentService studentService;
	private PruefungsleistungenService pruefungsleistungenService;
	
	private Pruefungsfach pruefungsfach;
	private List<Student> studenten;
	private List<Pruefungsleistung> pruefungsleistungen;
	private Note[] noten = Note.values();
	
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load Pruefungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
		
		// Load Studenten of Manipel and it´s Noten
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefungsfach(pruefungsfach);
		
		
		return SUCCESS;
	}
	
	/**
	 * savePruefungsleistungen
	 */
//	public String savePruefungsleistungen() throws Exception {
//		// Store Pruefungsleistungen in Database
//		pruefungsleistungenService.savePruefungsleistungen(pruefungsleistungen);
//		return SUCCESS;
//	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// If no Pruefung is selected, then show Error
		if (getSelectedPruefungId().equals(null)) {
			addFieldError("selectedPruefung", getText("error.no.pruefung.selected"));
		}
	}

	/**
	 * @param selectedPruefungsfachId the selectedPruefungsfachId to set
	 */
	public void setSelectedPruefungsfachId(Long selectedPruefungsfachId) {
		this.selectedPruefungsfachId = selectedPruefungsfachId;
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


	public Long getSelectedPruefungId() {
		return selectedPruefungId;
	}

	public void setSelectedPruefungId(Long selectedPruefungId) {
		this.selectedPruefungId = selectedPruefungId;
	}

	public Note[] getNoten() {
		return noten;
	}	

}
