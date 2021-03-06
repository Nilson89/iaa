package de.nordakademie.hausarbeit.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Pruefungsleistung;
import de.nordakademie.hausarbeit.model.Student;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.PruefungsleistungenService;
import de.nordakademie.hausarbeit.service.StudentService;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungenHistorieAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private PruefungsfaecherService pruefungsfaecherService;
	private PruefungsleistungenService pruefungsleistungenService;
	private List<Integer> matrikelnummern;
	private Long selectedPruefungsfachId;
	private Integer selectedMatrikelnummer;
	private static final Logger logger = Logger.getLogger(PruefungenHistorieAction.class);
	private Student student;
	private List<Pruefungsleistung> pruefungsleistungenList;
	private Pruefungsfach pruefungsfach;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		// Load MatrikelnummerList
		_loadMatrikelnummerList();
		return SUCCESS;
	}
	
	/**
	 * showDetail
	 */
	public String showDetail() {
		// Load Student by Matrikelnummer
		student = studentService.getStudentByMatrikelnummer(selectedMatrikelnummer);
		
		// Load Noten-History for student
		pruefungsleistungenList = pruefungsleistungenService.getHistoriePruefungen(student, pruefungsfach);
		
		return SUCCESS;
	}
	
	/**
	 * validate
	 */
	public void validate() {
		super.validate();
		
		// Load MatrikelnummerList
		_loadMatrikelnummerList();
		
		// Log selected Matrikelnummer
		if(logger.isDebugEnabled()){
			logger.debug("PruefungenHistorieAction: Matrikelnummer '" + selectedMatrikelnummer + "' selected");
		}
		
		// If no Manipel is selected, then show Error
		if (getSelectedMatrikelnummer().equals(0000)) {
			addFieldError("selectedMatrikelnummer", getText("error.no.matrikelnummer.selected"));
		}
	}
	
	/**
	 * _loadMatrikelnummerList
	 */
	private void _loadMatrikelnummerList() {
		if(logger.isDebugEnabled()){
			logger.debug("PruefungenHistorieAction: Loading Pruefungsfach with ID '" + selectedPruefungsfachId + "'...");
		}
		
		pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);		
		matrikelnummern = studentService.getMatrikelnummerListByManipel(pruefungsfach.getManipel());
	}

	/**
	 * @param studentService 
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	/**
	 * @return matrikelnummern
	 */
	public List<Integer> getMatrikelnummern() {
		return matrikelnummern;
	}

	/**
	 * @return selectedMatrikelnummer
	 */
	public Integer getSelectedMatrikelnummer() {
		return selectedMatrikelnummer;
	}

	/**
	 * @param selectedMatrikelnummer 
	 */
	public void setSelectedMatrikelnummer(Integer selectedMatrikelnummer) {
		this.selectedMatrikelnummer = selectedMatrikelnummer;
	}

	/**
	 * @param pruefungsfaecherService 
	 */
	public void setPruefungsfaecherService(
			PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}

	/**
	 * @return pruefungsleistungenList
	 */
	public List<Pruefungsleistung> getPruefungsleistungenList() {
		return pruefungsleistungenList;
	}

	/**
	 * @param pruefungsleistungenService 
	 */
	public void setPruefungsleistungenService(
			PruefungsleistungenService pruefungsleistungenService) {
		this.pruefungsleistungenService = pruefungsleistungenService;
	}

	/**
	 * @return pruefungsfach
	 */
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}

	/**
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}
}