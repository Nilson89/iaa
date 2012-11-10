package de.nordakademie.hausarbeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Ergaenzungspruefung {
	private Long id;
	private Note note;
	private Date datum;
	private Date erfassungsdatum;
	private Long pruefungsleistungId;
	
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
	 * @return note
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Note getNote() {
		return note;
	}
	/**
	 * @param note 
	 */
	public void setNote(Note note) {
		this.note = note;
	}
	
	/**
	 * @return datum
	 */
	@Column(nullable = false)
	@Type(type="date")
	public Date getDatum() {
		return datum;
	}
	/**
	 * @param datum 
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	/**
	 * @return erfassungsdatum
	 */
	@Column(nullable = false)
	@Type(type="date")
	public Date getErfassungsdatum() {
		return erfassungsdatum;
	}
	/**
	 * @param erfassungsdatum 
	 */
	public void setErfassungsdatum(Date erfassungsdatum) {
		this.erfassungsdatum = erfassungsdatum;
	}
	
	/**
	 * @return pruefungsleistungId
	 */
	@Transient
	public Long getPruefungsleistungId() {
		return pruefungsleistungId;
	}
	/**
	 * @param pruefungsleistungId 
	 */
	public void setPruefungsleistungId(Long pruefungsleistungId) {
		this.pruefungsleistungId = pruefungsleistungId;
	}
}