import java.util.GregorianCalendar;

public abstract class Kort implements Comparable<Kort>, Cloneable {
	private GregorianCalendar dateCreated;
	private String fornavn;
	private String etternavn;
	protected int pin;
	private int kortnummer;
	private int aksesskode;
	private boolean sperretKort;
	private static int antallkort = 100000;

	public Kort(String fornavn, String etternavn, int pin) {
		super();
		this.dateCreated = new GregorianCalendar();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pin = pin;
		this.kortnummer = ++antallkort;
		// this.aksesskode = aksesskode; ser ingen grunn i å ha med denne videre
		// uten flere opplysninger
		this.sperretKort = false;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public GregorianCalendar getDateCreated() {
		return dateCreated;
	}

	public boolean isSperret() {
		return sperretKort;
	}

	public void setSperretKort(boolean sperretKort) {
		this.sperretKort = sperretKort;
	}

	public abstract boolean sjekkPIN(int pin);

	@Override
	public int compareTo(Kort k) {
		int alfabetisk = this.getEtternavn().compareTo(k.getEtternavn());
			if (alfabetisk == 0) {
				alfabetisk = this.getFornavn().compareTo(k.getFornavn());
			}
			return alfabetisk;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Kort \nOpprettet: " + dateCreated.getTime() + "\nNavn: " + fornavn + " " + etternavn + "\nPin: " + pin
				+ "\nKortnummer: " + kortnummer + "\nAksesskode: " + aksesskode + "\nSperret: " + sperretKort + "\n\n";
	}

}