package de.nordakademie.hausarbeit.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Pruefung;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.service.ManipelService;
import de.nordakademie.hausarbeit.service.PruefungenService;


/**
 * 
 * @author Sabrina Schramm
 */

public class CreatePruefungAction extends ActionSupport {
	private transient  PruefungenService pruefungenService;
	private ManipelService manipelService;
	
	private String selectedManipel = "none";
	
	private List<Manipel> manipelList;
		
		
	/**
	 * execute
	 */
	public String execute() throws Exception {
			
		return SUCCESS;
	}
	
}
