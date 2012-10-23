package de.nordakademie.hausarbeit.action;

import com.opensymphony.xwork2.Action;

import de.nordakademie.hausarbeit.service.PruefungsfaecherService;

/**
 * 
 * @author Niels Maseberg
 */
public class IndexAction implements Action {
	private PruefungsfaecherService pruefungsfaecherService;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @param pruefungsfaecherService the pruefungsfaecherService to set
	 */
	public void setPruefungsfaecherService(PruefungsfaecherService pruefungsfaecherService) {
		this.pruefungsfaecherService = pruefungsfaecherService;
	}

}
