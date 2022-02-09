package enums;

public enum PalosBarajaEsp {
	BASTOS(1), COPAS(2), ESPADAS(3), OROS(4);
	
	
	private int value;
	
	private PalosBarajaEsp(int value) {
		this.value = value;
	}

	public int getValue(PalosBarajaEsp palo) {
		return palo.value;
	}
	
	public static PalosBarajaEsp getEnum(int value) {
		switch (value) {
		case 1: {
			return BASTOS;
		}
		case 2: {
			return COPAS;
		}
		case 3: {
			return ESPADAS;
		}
		case 4: {
			return OROS;
		}
		default:
			throw new IllegalArgumentException("El valor debe estar entre 1 y 4");
		}
	}
	
}
