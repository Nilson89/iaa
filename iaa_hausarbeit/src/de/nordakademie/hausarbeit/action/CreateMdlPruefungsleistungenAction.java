package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
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
	
	private List<Ergaenzungspruefung> ergaenzungspruefungenList = new ArrayList();
	
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
			System.out.println("Da is was drinne!!!");
			System.out.println("PruefungsleistungId: " + ergaenzungspruefung.getPruefungsleistungId());
			System.out.println("Datum: " + ergaenzungspruefung.getDatum());
			System.out.println("Note: " + ergaenzungspruefung.getNote());
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
		
		/*for (Student student : studenten) {
			Pruefungsleistung pruefungsleistung = student.getPruefungsleistungen().get(student.getPruefungsleistungen().size() - 1);
			
			Ergaenzungspruefung ergaenzungspruefung = new Ergaenzungspruefung();
			ergaenzungspruefung.setPruefungsleistungId(pruefungsleistung.getId());
			
			ergaenzungspruefungenList.add(ergaenzungspruefung);
		}*/
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
}