package haagahelia.fi.mobileDatabase.domain;

public class Device {
	
	private String laite, malli, yhteys, muisti, vari;

	public Device() {
		super();
	}

	public Device(String laite, String malli, String yhteys, String muisti, String vari) {
		super();
		this.laite = laite;
		this.malli = malli;
		this.yhteys = yhteys;
		this.muisti = muisti;
		this.vari = vari;
	}

	public String getLaite() {
		return laite;
	}

	public void setLaite(String laite) {
		this.laite = laite;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getYhteys() {
		return yhteys;
	}

	public void setYhteys(String yhteys) {
		this.yhteys = yhteys;
	}

	public String getMuisti() {
		return muisti;
	}

	public void setMuisti(String muisti) {
		this.muisti = muisti;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	@Override
	public String toString() {
		return "Device [laite=" + laite + ", malli=" + malli + ", yhteys=" + yhteys + ", muisti=" + muisti + ", vari="
				+ vari + "]";
	}
	
}
