package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.PruefungsfaecherService;

/**
 * 
 * @author Niels Maseberg
 */
public class IndexAction implements Action {
	private PruefungsfaecherService pruefungsfaecherService;
	private List<Pruefungsfach> pruefungsfaecher;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		pruefungsfaecher = pruefungsfaecherService.listPruefungen();
		return SUCCESS;
	}
	
	/**
	 * getPruefungsfaecher
	 * 
	 * @return List<Pruefungsfach>
	 */
	public List<Pruefungsfach> getPruefungsfaecher() {
		return pruefungsfaecher;
	}

	/**
	 * @param pruefungsfaecherService 
	 */
	public void setPruefungsfaecherService(PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}

}
