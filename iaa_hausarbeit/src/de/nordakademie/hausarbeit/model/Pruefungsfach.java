package de.nordakademie.hausarbeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Pruefungsfach {
	private Long id;
	private String titel;
	private String beschreibung;
	private Manipel manipel;
	
	/**
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return titel
	 */
	@Column(nullable = false)
	public String getTitel() {
		return titel;
	}
	/**
	 * @param titel 
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	/**
	 * @return beschreibung
	 */
	@Column(nullable = true)
	public String getBeschreibung() {
		return beschreibung;
	}
	/**
	 * @param beschreibung 
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	/**
	 * @return manipel
	 */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="manipelstudienrichtung", referencedColumnName="studienrichtung"),
		@JoinColumn(name="manipeljahrgang", referencedColumnName="jahrgang")
	})
	public Manipel getManipel() {
		return manipel;
	}
	/**
	 * @param manipel 
	 */
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}
}