package de.nordakademie.hausarbeit.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Ergaenzungspruefung;
import de.nordakademie.hausarbeit.model.Note;
import de.nordakademie.hausarbeit.model.Person;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.model.User;
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
	private Long selectedPruefungId = null;
	
	private PruefungenService pruefungenService;
	private PruefungsleistungenService pruefungsleistungenService;
	private StudentService studentService;
	private Pruefung pruefung;
	private List<Student> studenten;
	private List<Pruefungsleistung> pruefungsleistungenList = new ArrayList();
	private List<Pruefungsleistung> newPruefungsleistungenList = new ArrayList();
	
	
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
		System.out.println("Ich speicher");
		for (Pruefungsleistung pruefungsleistung : pruefungsleistungenList) {
			System.out.println("Eine Prüfungsleistung!!!!");
			
			// Load Student
			Student student = studentService.getStudentByMatrikelnummer(pruefungsleistung.getStudentmatrikelnummer());
			pruefungsleistung.setStudent(student);
			
			// Set Erfasser static till there is a securityconcept
			User user = new User();
			user.setId(Integer.valueOf(1).longValue());
			Person person = new Person();
			person.setId(Integer.valueOf(7).longValue());
			person.setName("Heinrich");
			person.setVorname("Ulrike");
			user.setPerson(person);
			pruefungsleistung.setErfasser(user);
			
			// Set Erfassungsdatum
			pruefungsleistung.setErfassungsdatum(new Date());
			
			// Save Pruefungsleistung
			if (!pruefungsleistung.getNote().equals(Note.KeineTeilnahme)) {
				// Set Properties
				if (pruefungsleistung.getNote().equals(Note.FUENF)) {
					pruefungsleistung.setMdl_moeglich(true);
				}
				pruefungsleistung.setPruefung(pruefung);
				pruefungsleistung = pruefungsleistungenService.createPruefungsleistung(pruefungsleistung);
			}
			
			// Add Pruefungsleistung to List of new Pruefungsleistungen
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
		if (getSelectedPruefungId() == null) {
			addActionError(getText("error.no.pruefung.selected"));
		} else {
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
		studenten = studentService.getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung(pruefung);

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
	 * @return the pruefungsleistungenList
	 */
	public List<Pruefungsleistung> getPruefungsleistungenList() {
		return pruefungsleistungenList;
	}

	/**
	 * @param pruefungsleistungenList the pruefungsleistungenList to set
	 */
	public void setPruefungsleistungenList(
			List<Pruefungsleistung> pruefungsleistungenList) {
		this.pruefungsleistungenList = pruefungsleistungenList;
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
	 * @return the newPruefungsleistungenList
	 */
	public List<Pruefungsleistung> getNewPruefungsleistungenList() {
		return newPruefungsleistungenList;
	}

	/**
	 * @param pruefungsleistungenService the pruefungsleistungenService to set
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
	}
}