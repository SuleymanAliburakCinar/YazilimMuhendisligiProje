import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Database db = new Database("DilKursu","1234");
		//Ogrenci ogr = new Ogrenci("Asaf", "Reis", "13254678987", "05651253554");
		//boolean res = ogrenciEkle(ogr);
		//Ogrenci o = ogrenciGetir("13910163058");
		/*if(res) {
			System.out.println("Islem basari ile gerceklesti");
		}else
			System.out.println("Islem basarisiz");
		*/
		//db.almKurslariGetir();
		//tumOgrencileriGetir();
		//tumKampanyalariGetir();
		//Kampanya kmp = kampanyaGetir(1);
		//kayitElemanlariniGetir();
	    //System.out.println(kmp.getKampanya_adi()+" : "+kmp.getAlinan_kurs_idler()+" - "+kmp.getBedava_verilen_kurs_id() );
		//ingKurslariGetir();
		//almKurslariGetir();
		
		
		//Ogrenci ogr = new Ogrenci("Ali", "Veli", "22345678902", "123123");

		//Kurs k = kurs_getir(1);
		//Kampanya kamp =kampanyaGetir(1);
		
		
		//boolean sonuc = ogrenci_ekle(ogr,k,kamp.getKampanyaId());
		//kurs_aktiflestir(k.getKursId(), ogr.getTc());
		//System.out.println(sonuc);
		
		
		/*   ArrayList<Integer> arr = new ArrayList<Integer>();

	        arr.add(1);
	        arr.add(2);
	        arr.add(3);
	        arr.add(4);

	        kampanya_ekle(arr, 1, "Yeni Kampanya",1);
		*/
		
		ArrayList<OdemeBilgisi> arr = new ArrayList<OdemeBilgisi>();

	    /*    ArrayList<Integer> arr = new ArrayList<Integer>();

	        arr.add(1);
	        arr.add(2);
	        arr.add(3);
	        arr.add(4);

	        db.kampanya_ekle(arr, 1, "Yeni Kampanya",1);*/


				boolean sonuc;
	            Ogrenci ogr = new Ogrenci("Furkan", "Veli", "12345678912", "123123");

	            Kurs k1 = db.kurs_getir(1);
	            Kurs k2 = db.kurs_getir(6);
	            Kampanya kamp = db.kampanyaGetir(1);

	            sonuc = db.ogrenci_ekle(ogr,k1,kamp.getKampanyaId());
	            System.out.println(sonuc);


	            sonuc = db.ogrenci_ekle(ogr,k2,0);
	            System.out.println(sonuc);


	            arr = db.odeme_bilgisi_getir(ogr.getTc());

	        for(OdemeBilgisi i : arr) {

	            System.out.println(i.getOgrenciId());
	        }
		
	}
	

	
	
}
