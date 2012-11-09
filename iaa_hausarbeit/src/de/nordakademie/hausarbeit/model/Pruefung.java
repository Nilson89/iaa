package de.nordakademie.hausarbeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Pruefung {
	private Long id;
	private Date datum;
	private Pruefungsfach pruefungsfach;
	private Dozent dozent;
	
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
	 * @return pruefungsfach
	 */
	@ManyToOne
	@JoinColumn(name="pruefungsfachid", referencedColumnName="id")
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}
	/**
	 * @param pruefungsfach 
	 */
	public void setPruefungsfach(Pruefungsfach pruefungsfach) {
		this.pruefungsfach = pruefungsfach;
	}
	
	/**
	 * @return dozent
	 */
	@ManyToOne
	@JoinColumn(name="dozentid", referencedColumnName="id")
	public Dozent getDozent() {
		return dozent;
	}
	/**
	 * @param dozent 
	 */
	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}
}