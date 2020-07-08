
import java.util.ArrayList;

public class Kurs {
	
	private int kursId;
	private String kursAdi;
	private String kursDili;
	private int sinif;
	private int sube;
	private String kur;
	private int ogrenci_sayisi;
	private String ogretmenId;
	
	public Kurs(int kursId, String kursAdi, String kursDili, int sinif, int sube, String kur, int ogrenci_sayisi,String ogretmenId) {
		this.kursId = kursId;
		this.kursAdi = kursAdi;
		this.kursDili = kursDili;
		this.sinif = sinif;
		this.sube = sube;
		this.kur = kur;
		this.ogrenci_sayisi = ogrenci_sayisi;
		this.ogretmenId = ogretmenId;
	}

	public int getKursId() {
		return kursId;
	}

	public void setKursId(int kursId) {
		this.kursId = kursId;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public String getKursDili() {
		return kursDili;
	}

	public void setKursDili(String kursDili) {
		this.kursDili = kursDili;
	}

	public int getSinif() {
		return sinif;
	}

	public void setSinif(int sinif) {
		this.sinif = sinif;
	}

	public int getSube() {
		return sube;
	}

	public void setSube(int sube) {
		this.sube = sube;
	}

	public String getKur() {
		return kur;
	}

	public void setKur(String kur) {
		this.kur = kur;
	}

	public int getOgrenci_sayisi() {
		return ogrenci_sayisi;
	}

	public void setOgrenci_sayisi(int ogrenci_sayisi) {
		this.ogrenci_sayisi = ogrenci_sayisi;
	}

	public String getOgretmenId() {
		return ogretmenId;
	}

	public void setOgretmenId(String ogretmenId) {
		this.ogretmenId = ogretmenId;
	}
	
	
	

	
	

}
