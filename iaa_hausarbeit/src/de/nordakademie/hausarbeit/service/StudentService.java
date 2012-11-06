package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg
 */
public interface StudentService {
	public List<Integer> getMatrikelnummerListByManipel(Manipel manipel);
	public Student getStudentByMatrikelnummer(Integer matrikelnummer);
	public List<Student> getStudentenByManipel(Manipel manipel);
}