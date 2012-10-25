package de.nordakademie.hausarbeit.model;

/**
 * 
 * @author Niels Maseberg
 */
public enum Note {
	EINS("1.0"),
	EINSDREI("1.3"),
	EINSSIEBEN("1.7"),
	ZWEI("2.0"),
	ZWEIDREI("2.3"),
	ZWEISIEBEN("2.7"),
	DREI("3.0"),
	DREIDREI("3.3"),
	DREISIEBEN("3.7"),
	VIER("4.0"),
	FUENF("5.0"),
	SECHS("6.0");
	
	private String value;
	
	/**
	 * constructor
	 * 
	 * @param String the value
	 */
	Note(String value) {
		this.value = value;
	}

	/**
	 * toString
	 */
	public String toString() {
		return value;
	}
}