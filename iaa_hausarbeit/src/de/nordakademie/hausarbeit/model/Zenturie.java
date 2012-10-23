package de.nordakademie.hausarbeit.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Niels Maseberg
 */
public class Zenturie {
	private Long id;
	private String kuerzel;
	private Manipel manipel;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the kuerzel
	 */
	public String getKuerzel() {
		return kuerzel;
	}
	/**
	 * @param kuerzel the kuerzel to set
	 */
	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}
	/**
	 * @return the manipel
	 */
	public Manipel getManipel() {
		return manipel;
	}
	/**
	 * @param manipel the manipel to set
	 */
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}
}