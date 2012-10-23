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
	 * @return the titel
	 */
	@Column(nullable = false)
	public String getTitel() {
		return titel;
	}
	/**
	 * @param titel the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	/**
	 * @return the beschreibung
	 */
	@Column(nullable = true)
	public String getBeschreibung() {
		return beschreibung;
	}
	/**
	 * @param beschreibung the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	/**
	 * @return the manipel
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
	 * @param manipel the manipel to set
	 */
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}
}
