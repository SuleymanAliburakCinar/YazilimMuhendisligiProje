


public class OdemeBilgisi {

	private int odemeId;
	private int taksit_sayisi;
	private int odenen_taksit_sayisi;
	private boolean borc_var_mi;
	private String ogrenciId;
	private int toplamfiyat;
	private int birimtaksitfiyat;
	
	public OdemeBilgisi(int odemeId, int taksit_sayisi, int odenen_taksit_sayisi, boolean borc_var_mi, String ogrenciId,int toplamfiyat, int birimtaksitfiyat) {
		
		this.odemeId = odemeId;
		this.taksit_sayisi = taksit_sayisi;
		this.odenen_taksit_sayisi = odenen_taksit_sayisi;
		this.borc_var_mi = borc_var_mi;
		this.ogrenciId = ogrenciId;
		this.toplamfiyat = toplamfiyat;
		this.birimtaksitfiyat = birimtaksitfiyat;
	}
	
	public OdemeBilgisi() {}

	public int getOdemeId() {
		return odemeId;
	}

	public void setOdemeId(int odemeId) {
		this.odemeId = odemeId;
	}

	public int getTaksit_sayisi() {
		return taksit_sayisi;
	}

	public void setTaksit_sayisi(int taksit_sayisi) {
		this.taksit_sayisi = taksit_sayisi;
	}

	public int getOdenen_taksit_sayisi() {
		return odenen_taksit_sayisi;
	}

	public void setOdenen_taksit_sayisi(int odenen_taksit_sayisi) {
		this.odenen_taksit_sayisi = odenen_taksit_sayisi;
	}

	public boolean isBorc_var_mi() {
		return borc_var_mi;
	}

	public void setBorc_var_mi(boolean borc_var_mi) {
		this.borc_var_mi = borc_var_mi;
	}

	public String getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(String ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public int getToplamfiyat() {
		return toplamfiyat;
	}

	public void setToplamfiyat(int toplamfiyat) {
		this.toplamfiyat = toplamfiyat;
	}

	public int getBirimtaksitfiyat() {
		return birimtaksitfiyat;
	}

	public void setBirimtaksitfiyat(int birimtaksitfiyat) {
		this.birimtaksitfiyat = birimtaksitfiyat;
	}
	
	
	
	
	
	
	
	
}
