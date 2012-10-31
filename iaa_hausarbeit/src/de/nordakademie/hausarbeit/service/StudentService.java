package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Manipel;

/**
 * 
 * @author Niels Maseberg
 */
public interface StudentService {
	public List<Integer> getMatrikelnummerListByManipel(Manipel manipel);
}