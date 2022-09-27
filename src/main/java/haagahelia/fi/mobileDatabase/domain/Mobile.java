package haagahelia.fi.mobileDatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mobile {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    private String laite;
	    private String malli;
	    private String yhteys;
	    private String muisti; 
	    private String vari;
	    
	    @ManyToOne
	    @JoinColumn(name = "typeid")
	    private Type type;

		public Mobile() {
			super();
		}

		public Mobile(String laite, String malli, String yhteys, String muisti, String vari, Type type) {
			super();
			this.laite = laite;
			this.malli = malli;
			this.yhteys = yhteys;
			this.muisti = muisti;
			this.vari = vari;
			this.type = type;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		@Override
		public String toString() {
			if (this.type != null)
				return "Mobile [id=" + id + ", laite=" + laite + ", malli=" + malli + ", yhteys=" + yhteys + ", muisti="
					+ muisti + ", vari=" + vari + ", type=" + type + " type = " + this.getType() + "]";
			else
				return "Mobile [id=" + id + ", laite=" + laite + ", malli=" + malli + ", yhteys=" + yhteys + ", muisti="
				+ muisti + ", vari=" + vari + ", type=" + type + "]";
				
		}
		 
}
