

public class Kampanya {
	private int kampanyaId;
	private String alinan_kurs_idler;
	private String bedava_verilen_kurs_id;
	private String kampanya_adi;
	private int fiyat;

	public Kampanya() {}
	

	public Kampanya(int kampanyaId,String kampanya_adi, int fiyat,String alinan_kurs_idler, String bedava_verilen_kurs_id) {
	    this.kampanyaId = kampanyaId;
	    this.alinan_kurs_idler = alinan_kurs_idler;
	    this.bedava_verilen_kurs_id = bedava_verilen_kurs_id;
	    this.kampanya_adi = kampanya_adi;
	    this.fiyat = fiyat;
	}


	public int getKampanyaId() {
	    return kampanyaId;
	}
	public void setKampanyaId(int kampanyaId) {
	    this.kampanyaId = kampanyaId;
	}
	public String getKampanya_adi() {
	    return kampanya_adi;
	}
	public void setKampanya_adi(String kampanya_adi) {
	    this.kampanya_adi = kampanya_adi;
	}
	public int getFiyat() {
	    return fiyat;
	}
	public void setFiyat(int fiyat) {
	    this.fiyat = fiyat;
	}
	
	public String getAlinan_kurs_idler() {
	    return alinan_kurs_idler;
	}
	public void setAlinan_kurs_idler(String alinan_kurs_idler) {
	    this.alinan_kurs_idler = alinan_kurs_idler;
	}
	public String getBedava_verilen_kurs_id() {
	    return bedava_verilen_kurs_id;
	}
	public void setBedava_verilen_kurs_id(String bedava_verilen_kurs_id) {
	    this.bedava_verilen_kurs_id = bedava_verilen_kurs_id;
	}
	public String toString(){
            return kampanya_adi+"\t\t "+ fiyat+"\t "+alinan_kurs_idler+"\t\t\t  "+bedava_verilen_kurs_id;
        }
	

}
