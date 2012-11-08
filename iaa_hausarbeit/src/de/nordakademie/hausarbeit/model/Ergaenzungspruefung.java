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
	 * @return the note
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Note getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(Note note) {
		this.note = note;
	}
	
	/**
	 * @return the datum
	 */
	@Column(nullable = false)
	@Type(type="date")
	public Date getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	/**
	 * @return the erfassungsdatum
	 */
	@Column(nullable = false)
	@Type(type="date")
	public Date getErfassungsdatum() {
		return erfassungsdatum;
	}
	/**
	 * @param erfassungsdatum the erfassungsdatum to set
	 */
	public void setErfassungsdatum(Date erfassungsdatum) {
		this.erfassungsdatum = erfassungsdatum;
	}
	
	/**
	 * @return the pruefungsleistungId
	 */
	@Transient
	public Long getPruefungsleistungId() {
		return pruefungsleistungId;
	}
	/**
	 * @param pruefungsleistungId the pruefungsleistungId to set
	 */
	public void setPruefungsleistungId(Long pruefungsleistungId) {
		this.pruefungsleistungId = pruefungsleistungId;
	}
}