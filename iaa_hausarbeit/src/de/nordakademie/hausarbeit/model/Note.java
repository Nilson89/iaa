package de.nordakademie.hausarbeit.model;

/**
 * 
 * @author Niels Maseberg, Sabrina Schramm
 */
public enum Note {
	KeineTeilnahme {
		public String toString() {
			return "nicht teilgenommen";
		}
	}, 
	
	EINS {
		public String toString() {
			return "1.0";
		}
	},
	EINSDREI {
		public String toString() {
			return "1.3";
		}
	},
	EINSSIEBEN {
		public String toString() {
			return "1.7";
		}
	},
	ZWEI {
		public String toString() {
			return "2.0";
		}
	},
	ZWEIDREI {
		public String toString() {
			return "2.3";
		}
	},
	ZWEISIEBEN {
		public String toString() {
			return "2.7";
		}
	},
	DREI {
		public String toString() {
			return "3.0";
		}
	},
	DREIDREI {
		public String toString() {
			return "3.3";
		}
	},
	DREISIEBEN {
		public String toString() {
			return "3.7";
		}
	},
	VIER {
		public String toString() {
			return "4.0";
		}
	},
	FUENF {
		public String toString() {
			return "5.0*";
		}
	},
	SECHS {
		public String toString() {
			return "5.0**";
		}
	};
	
	public static Note getEnum(String value) throws IllegalArgumentException {
		if (value.equals("1.0")) {
			return Note.EINS;
		} else if (value.equals("1.3")) {
			return Note.EINSDREI;
		} else if (value.equals("1.7")) {
			return Note.EINSSIEBEN;
		} else if (value.equals("2.0")) {
			return Note.ZWEI;
		} else if (value.equals("2.3")) {
			return Note.ZWEIDREI;
		} else if (value.equals("2.7")) {
			return Note.ZWEISIEBEN;
		} else if (value.equals("3.0")) {
			return Note.DREI;
		} else if (value.equals("3.3")) {
			return Note.DREIDREI;
		} else if (value.equals("3.7")) {
			return Note.DREISIEBEN;
		} else if (value.equals("4.0")) {
			return Note.VIER;
		} else if (value.equals("5.0")) {
			return Note.FUENF;
		} else if (value.equals("6.0")) {
			return Note.SECHS;
		} else if (value.equals("nicht teilgenommen")) {
			return Note.KeineTeilnahme;
		} else {
			throw new IllegalArgumentException("Given String '" + value +"' could not be resolved to a value of Note");
		}
	}
}