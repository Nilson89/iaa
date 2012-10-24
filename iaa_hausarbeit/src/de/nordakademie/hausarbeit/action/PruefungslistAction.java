package de.nordakademie.hausarbeit.action;

import com.opensymphony.xwork2.Action;

import de.nordakademie.hausarbeit.service.PruefungenService;

/**
 * 
 * @author Niels Maseberg
 */
public class PruefungslistAction implements Action {
	private PruefungenService pruefungenService;
	
	/**
	 * execute
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

}
