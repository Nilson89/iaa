package de.nordakademie.hausarbeit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/**
 * 
 * @author Niels Maseberg
 */
@Entity
public class Manipel {
	@Id
	private ManipelPK pk = new ManipelPK();

	/**
	 * @return the pk
	 */
	public ManipelPK getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(ManipelPK pk) {
		this.pk = pk;
	}
}