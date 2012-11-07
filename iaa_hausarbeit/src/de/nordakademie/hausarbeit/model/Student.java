package de.nordakademie.hausarbeit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
@FetchProfile(name = "student-with-pruefungsleistungen", fetchOverrides = {
   @FetchProfile.FetchOverride(entity = Student.class, association = "pruefungsleistungen", mode = FetchMode.JOIN)
})
public class Student {
	private int matrikelnummer;
	private Person person;
	private Manipel manipel;
	private List<Pruefungsleistung> pruefungsleistungen;
	
	/**
	 * @return the matrikelnummer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	/**
	 * @param matrikelnummer the matrikelnummer to set
	 */
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	/**
	 * @return the person
	 */
	@OneToOne
	@JoinColumn(name= "personid")
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	
	/**
	 * @return the pruefungsleistungen
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy="student")
	public List<Pruefungsleistung> getPruefungsleistungen() {
		return pruefungsleistungen;
	}
	/**
	 * @param pruefungsleistungen the pruefungsleistungen to set
	 */
	public void setPruefungsleistungen(List<Pruefungsleistung> pruefungsleistungen) {
		this.pruefungsleistungen = pruefungsleistungen;
	}
}
