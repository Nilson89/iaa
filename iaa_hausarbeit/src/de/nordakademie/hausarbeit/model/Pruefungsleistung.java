package de.nordakademie.hausarbeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Pruefungsleistung {
	private Long id;
	private int versuch;
	@Enumerated(EnumType.STRING)
	private Note note;
	private boolean mdl_moeglich = false;
	private boolean gueltig = true;
	private Date erfassungsdatum;
	private Pruefung pruefung;
	private Student student;
	private User erfasser;
	private Ergaenzungspruefung ergaenzungspruefung;
	
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
	 * @return the versuch
	 */
	@Column(nullable = false)
	public int getVersuch() {
		return versuch;
	}
	/**
	 * @param versuch the versuch to set
	 */
	public void setVersuch(int versuch) {
		this.versuch = versuch;
	}
	
	/**
	 * @return the note
	 */
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
	 * @return the mdl_moeglich
	 */
	@Column(nullable = false)
	public boolean isMdl_moeglich() {
		return mdl_moeglich;
	}
	/**
	 * @param mdl_moeglich the mdl_moeglich to set
	 */
	public void setMdl_moeglich(boolean mdl_moeglich) {
		this.mdl_moeglich = mdl_moeglich;
	}
	
	/**
	 * @return the gueltig
	 */
	@Column(nullable = false)
	public boolean isGueltig() {
		return gueltig;
	}
	/**
	 * @param gueltig the gueltig to set
	 */
	public void setGueltig(boolean gueltig) {
		this.gueltig = gueltig;
	}
	
	/**
	 * @return the erfassungsdatum
	 */
	@Column(nullable = false)
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
	 * @return the pruefung
	 */
	@ManyToOne
	@JoinColumn(name="pruefungid", referencedColumnName="id")
	public Pruefung getPruefung() {
		return pruefung;
	}
	/**
	 * @param pruefung the pruefung to set
	 */
	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}
	
	/**
	 * @return the student
	 */
	@ManyToOne
	@JoinColumn(name="studentmatrikelnummer", referencedColumnName="matrikelnummer")
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * @return the erfasser
	 */
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="id")
	public User getErfasser() {
		return erfasser;
	}
	/**
	 * @param erfasser the erfasser to set
	 */
	public void setErfasser(User erfasser) {
		this.erfasser = erfasser;
	}
	
	/**
	 * @return the ergaenzungspruefung
	 */
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="pruefungsleistungid")
	@NotFound(action=NotFoundAction.IGNORE)
	public Ergaenzungspruefung getErgaenzungspruefung() {
		return ergaenzungspruefung;
	}
	/**
	 * @param ergaenzungspruefung the ergaenzungspruefung to set
	 */
	public void setErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung) {
		this.ergaenzungspruefung = ergaenzungspruefung;
	}
}