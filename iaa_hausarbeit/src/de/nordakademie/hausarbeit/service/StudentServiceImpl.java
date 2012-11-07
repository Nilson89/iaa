package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.StudentDAO;
import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Pruefungsfach;
import de.nordakademie.hausarbeit.model.Student;

/**
 * 
 * @author Niels Maseberg
 */
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	/**
	 * getMatrikelnummerListByManipel
	 * 
	 * @param Manipel the Manipel to get Matrikelnummerlist for
	 * @return List<Integer> the List of Matrikelnummer
	 */
	public List<Integer> getMatrikelnummerListByManipel(Manipel manipel) {
		return studentDAO.loadMatrikelnummerListByManipel(manipel);
	}
	
	/**
	 * getStudentByMatrikelnummer
	 * 
	 * @param Integer the matrikelnummer
	 * @return Student the Student
	 */
	public Student getStudentByMatrikelnummer(Integer matrikelnummer) {
		return studentDAO.loadStudent(matrikelnummer);
	}

	/**
	 * getStudentenByManipelAndPruefungsleistungenByPruefungsfach
	 * 
	 * @param Pruefungsfach the pruefungsfach
	 * @return List<Student>
	 */
	public List<Student> getStudentenByManipelAndPruefungsleistungenByPruefungsfach(Pruefungsfach pruefungsfach) {
		return studentDAO.getStudentenByManipelAndPruefungsleistungenByPruefungsfach(pruefungsfach);
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}