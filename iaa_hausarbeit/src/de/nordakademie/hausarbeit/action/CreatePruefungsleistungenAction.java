package de.nordakademie.hausarbeit.action;

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
	private StudentService studentService;
	private Pruefung pruefung;
	private Pruefungsfach pruefungsfach;
	private List<Student> studenten;
	private List<Pruefungsleistung> pruefungsleistungenList;
	private Note[] noten = Note.values();
	
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		
		// Load Prüfungunsfach and Studenten of Manipel and it´s Noten
		loadPruefungAndStudents();
		
		return SUCCESS;

	}
	
	/**
	 * savePruefungsleistungen
	 */
	public String save() throws Exception {
		for (Pruefungsleistung pruefungsleistung : pruefungsleistungenList) {
			System.out.println("PruefungsleistungId: " + pruefungsleistung.getId());
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

	public Note[] getNoten() {
		return noten;
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
	public List<Pruefungsleistung> getPruefungsleistungenListt() {
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
