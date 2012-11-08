package de.nordakademie.hausarbeit.struts.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import de.nordakademie.hausarbeit.model.Note;

/**
 * 
 * @author Niels Maseberg
 */
public class NoteConverter extends StrutsTypeConverter {
	/**
	 * convertFromString
	 */
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Note note = Note.getEnum(arg1[0]);
		return note;
	}

	/**
	 * convertToString
	 * 
	 * Simply returns the toString()-Method of the Class de.nordakademie.hausarbeit.model.Note
	 */
	public String convertToString(Map arg0, Object arg1) {
		return arg1.toString();
	}
}