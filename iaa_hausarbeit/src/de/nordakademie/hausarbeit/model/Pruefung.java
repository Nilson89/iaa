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
	 * @return the pruefungsfach
	 */
	@ManyToOne
	@JoinColumn(name="pruefungsfachid", referencedColumnName="id")
	public Pruefungsfach getPruefungsfach() {
		return pruefungsfach;
	}
	/**
	 * @param pruefungsfach the pruefungsfach to set
	 */
	public void setPruefungsfach(Pruefungsfach pruefungsfach) {
		this.pruefungsfach = pruefungsfach;
	}
	
	/**
	 * @return the dozent
	 */
	@ManyToOne
	@JoinColumn(name="dozentid", referencedColumnName="id")
	public Dozent getDozent() {
		return dozent;
	}
	/**
	 * @param dozent the dozent to set
	 */
	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}
}