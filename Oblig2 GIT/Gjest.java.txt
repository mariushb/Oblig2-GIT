import java.util.GregorianCalendar;

public class Gjest extends Kort {
	private int dagerGyldig = 7;
	private GregorianCalendar gyldigTilDato;
	private GregorianCalendar dateToday;

	public Gjest(String fornavn, String etternavn) {
		super(fornavn, etternavn, 9999);
		this.gyldigTilDato = new GregorianCalendar();
		gyldigTilDato.add(GregorianCalendar.DAY_OF_MONTH, dagerGyldig);
	}

	public GregorianCalendar getGyldigTilDato() {
		return gyldigTilDato;
	}

	@Override
	public boolean sjekkPIN(int pin) {
		this.dateToday = new GregorianCalendar();
		if (isSperret()) {
			return false;
		} else if (gyldigTilDato.before(dateToday)) {
			super.setSperretKort(true);
			return false;
		} else {
			return this.pin == pin;
		}
	}

	@Override
	public String toString() {
		return "Gjest \nDager Gyldig: " + dagerGyldig + "\nGyldig Til Dato: " + gyldigTilDato.getTime() + "\n"
				+ super.toString();
	}

}