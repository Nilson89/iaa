package de.nordakademie.hausarbeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Pruefungsleistung {
	private Long id;
	private int versuch;
	private Note note;
	private boolean mdl_moeglich = false;
	private boolean gueltig = true;
	private Date erfassungsdatum;
	private Pruefung pruefung;
	private Student student;
	private int studentmatrikelnummer;
	private User erfasser;
	private Ergaenzungspruefung ergaenzungspruefung;
	private boolean aenderungseintrag = false;
	
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
	 * @return versuch
	 */
	@Column(nullable = false)
	public int getVersuch() {
		return versuch;
	}
	/**
	 * @param versuch
	 */
	public void setVersuch(int versuch) {
		this.versuch = versuch;
	}
	
	/**
	 * @return note
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
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
	 * @return mdl_moeglich
	 */
	@Column(nullable = false)
	public boolean isMdl_moeglich() {
		return mdl_moeglich;
	}
	/**
	 * @param mdl_moeglich 
	 */
	public void setMdl_moeglich(boolean mdl_moeglich) {
		this.mdl_moeglich = mdl_moeglich;
	}
	
	/**
	 * @return gueltig
	 */
	@Column(nullable = false)
	public boolean isGueltig() {
		return gueltig;
	}
	/**
	 * @param gueltig 
	 */
	public void setGueltig(boolean gueltig) {
		this.gueltig = gueltig;
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
	 * @return pruefung
	 */
	@ManyToOne
	@JoinColumn(name="pruefungid", referencedColumnName="id")
	public Pruefung getPruefung() {
		return pruefung;
	}
	/**
	 * @param pruefung 
	 */
	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}
	
	/**
	 * @return student
	 */
	@ManyToOne
	@JoinColumn(name="studentmatrikelnummer")
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * @return erfasser
	 */
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="id")
	public User getErfasser() {
		return erfasser;
	}
	/**
	 * @param erfasser 
	 */
	public void setErfasser(User erfasser) {
		this.erfasser = erfasser;
	}
	
	/**
	 * @return ergaenzungspruefung
	 */
	@OneToOne
	@JoinColumn(name="ergaenzungspruefungid", referencedColumnName="id")
	@NotFound(action=NotFoundAction.IGNORE)
	public Ergaenzungspruefung getErgaenzungspruefung() {
		return ergaenzungspruefung;
	}
	/**
	 * @param ergaenzungspruefung 
	 */
	public void setErgaenzungspruefung(Ergaenzungspruefung ergaenzungspruefung) {
		this.ergaenzungspruefung = ergaenzungspruefung;
	}
	
	/**
	 * @return aenderungseintrag
	 */
	@Column(nullable = false)
	public boolean isAenderungseintrag() {
		return aenderungseintrag;
	}
	/**
	 * @param aenderungseintrag
	 */
	public void setAenderungseintrag(boolean aenderungseintrag) {
		this.aenderungseintrag = aenderungseintrag;
	}
	
	/**
	 * getEndNote
	 * 
	 * @return note
	 */
	@Transient
	public Note getEndNote() {
		if (ergaenzungspruefung != null) {
			// Get final grade
			switch (ergaenzungspruefung.getNote()) {
			case EINS:
			case EINSDREI:
				return Note.DREISIEBEN;
			case EINSSIEBEN:
			case ZWEI:
				return Note.VIER;
			default:
				return Note.FUENF;
			}
		} else {
			return note;
		}
	}
	/**
	 * @return studentmatrikelnummer
	 */
	@Transient
	public int getStudentmatrikelnummer() {
		return studentmatrikelnummer;
	}
	/**
	 * @param studentmatrikelnummer 
	 */
	public void setStudentmatrikelnummer(int studentmatrikelnummer) {
		this.studentmatrikelnummer = studentmatrikelnummer;
	}
}