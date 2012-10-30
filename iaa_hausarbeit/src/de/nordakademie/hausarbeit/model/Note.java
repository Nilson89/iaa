package de.nordakademie.hausarbeit.model;

/**
 * 
 * @author Niels Maseberg
 */
public enum Note {
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
			return "5.0";
		}
	},
	SECHS {
		public String toString() {
			return "6.0";
		}
	};
}