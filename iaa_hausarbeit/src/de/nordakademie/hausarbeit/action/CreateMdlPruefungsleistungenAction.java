package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungenService;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
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
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load Pruefung
		pruefung = pruefungenService.getPruefungById(selectedPruefungId);
		
		// Load Studenten and its grades
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefung(pruefung);
		
		return SUCCESS;
	}

	/**
	 * validate
	 */
	public void validate() {
		super.validate();
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
}