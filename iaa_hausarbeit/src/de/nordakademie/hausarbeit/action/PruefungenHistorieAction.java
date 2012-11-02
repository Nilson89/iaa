package de.nordakademie.hausarbeit.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;
import de.nordakademie.hausarbeit.service.StudentService;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungenHistorieAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private PruefungsfaecherService pruefungsfaecherService;
	private List<Integer> matrikelnummern;
	private Long selectedPruefungsfachId;
	private Integer selectedMatrikelnummer;
	private static final Logger logger = Logger.getLogger(PruefungenHistorieAction.class);
	
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
		// Load Noten-History
		// TODO
		
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
		
		Pruefungsfach pruefungsfach = pruefungsfaecherService.getPruefungsfach(selectedPruefungsfachId);		
		matrikelnummern = studentService.getMatrikelnummerListByManipel(pruefungsfach.getManipel());
	}

	/**
	 * @param studentService the studentService to set
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	/**
	 * @return the matrikelnummern
	 */
	public List<Integer> getMatrikelnummern() {
		return matrikelnummern;
	}

	/**
	 * @return the selectedMatrikelnummer
	 */
	public Integer getSelectedMatrikelnummer() {
		return selectedMatrikelnummer;
	}

	/**
	 * @param selectedMatrikelnummer the selectedMatrikelnummer to set
	 */
	public void setSelectedMatrikelnummer(Integer selectedMatrikelnummer) {
		this.selectedMatrikelnummer = selectedMatrikelnummer;
	}

	/**
	 * @param pruefungsfaecherService the pruefungsfaecherService to set
	 */
	public void setPruefungsfaecherService(
			PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}
}