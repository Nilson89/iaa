package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.dao.StudentDAO;
import de.nordakademie.hausarbeit.model.Manipel;
import de.nordakademie.hausarbeit.model.Pruefung;
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
	 * @param manipel
	 * @return List<Matrikelnummer>
	 */
	public List<Integer> getMatrikelnummerListByManipel(Manipel manipel) {
		return studentDAO.loadMatrikelnummerListByManipel(manipel);
	}
	
	/**
	 * getStudentByMatrikelnummer
	 * 
	 * @param matrikelnummer
	 * @return student
	 */
	public Student getStudentByMatrikelnummer(Integer matrikelnummer) {
		return studentDAO.loadStudent(matrikelnummer);
	}

	/**
	 * getStudentenByManipelAndPruefungsleistungenByPruefungsfach
	 * 
	 * @param pruefungsfach
	 * @return List<Student>
	 */
	public List<Student> getStudentenByManipelAndPruefungsleistungenByPruefungsfach(Pruefungsfach pruefungsfach) {
		return studentDAO.getStudentenByManipelAndPruefungsleistungenByPruefungsfach(pruefungsfach);
	}

	/**
	 * @param studentDAO
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * getStudentenByManipelAndPruefungsleistungenByPruefung
	 * 
	 * @param pruefung
	 */
	public List<Student> getStudentenByManipelAndPruefungsleistungenByPruefung(Pruefung pruefung) {
		return studentDAO.getStudentenByManipelAndPruefungsleistungenByPruefung(pruefung);
	}
	
	/**
	 * getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung
	 * 
	 * @param pruefung
	 */
	public List<Student> getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung(Pruefung pruefung) {
		return studentDAO.getStudentenByManipelWithLessThenThreeGradesAndPruefungsleistungenByPruefung(pruefung);
	}

}