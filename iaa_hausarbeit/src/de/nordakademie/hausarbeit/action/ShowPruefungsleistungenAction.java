package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;
import de.nordakademie.hausarbeit.service.StudentService;


/**
 * 
 * @author Sabrina Schramm und Niels Maseberg
 */
public class ShowPruefungsleistungenAction extends ActionSupport {
	private Long selectedPruefungsfachId;
	
	private PruefungsfaecherService pruefungsfaecherService;
	private StudentService studentService;
	
	private Pruefungsfach pruefungsfach;
	private List<Student> studenten;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load Pruefungsfach
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);
		
		// Load Students of Manipel and it´s grades
		studenten = studentService.getStudentenByManipelAndPruefungsleistungenByPruefungsfach(pruefungsfach);
		
		
		return SUCCESS;
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
	
}