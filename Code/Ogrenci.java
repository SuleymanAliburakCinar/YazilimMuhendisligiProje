
import java.util.ArrayList;

public class Ogrenci {
private String isim;
private String soyisim;
private String tc;
private String telno;

private ArrayList<Kurs> yazildigi_kurslar;
private OdemeBilgisi odeme_bilgileri;
private Kampanya yayarlandigi_kampanya;



public Ogrenci(String isim, String soyisim, String tc, String telno, ArrayList<Kurs> yazildigi_kurslar,
		OdemeBilgisi odeme_bilgileri, Kampanya yayarlandigi_kampanya) {
	this.isim = isim;
	this.soyisim = soyisim;
	this.tc = tc;
	this.telno = telno;
	this.yazildigi_kurslar = yazildigi_kurslar;
	this.odeme_bilgileri = odeme_bilgileri;
	this.yayarlandigi_kampanya = yayarlandigi_kampanya;
}

public Ogrenci(String isim, String soyisim, String tc, String telno) {
	this.isim = isim;
	this.soyisim = soyisim;
	this.tc = tc;
	this.telno = telno;
}

public String getIsim() {
	return isim;
}
public void setIsim(String isim) {
	this.isim = isim;
}
public String getSoyisim() {
	return soyisim;
}
public void setSoyisim(String soyisim) {
	this.soyisim = soyisim;
}
public String getTc() {
	return tc;
}
public void setTc(String tc) {
	this.tc = tc;
}
public String getTelno() {
	return telno;
}
public void setTelno(String telno) {
	this.telno = telno;
}
public ArrayList<Kurs> getYazildigi_kurslar() {
	return yazildigi_kurslar;
}
public void setYazildigi_kurslar(ArrayList<Kurs> yazildigi_kurslar) {
	this.yazildigi_kurslar = yazildigi_kurslar;
}

public void kursaKaydet(Kurs k) {
	yazildigi_kurslar.add(k);
}

public OdemeBilgisi getOdeme_bilgileri() {
	return odeme_bilgileri;
}
public void setOdeme_bilgileri(OdemeBilgisi odeme_bilgileri) {
	this.odeme_bilgileri = odeme_bilgileri;
}
public Kampanya getYayarlandigi_kampanya() {
	return yayarlandigi_kampanya;
}
public void setYayarlandigi_kampanya(Kampanya yayarlandigi_kampanya) {
	this.yayarlandigi_kampanya = yayarlandigi_kampanya;
}


	
}
