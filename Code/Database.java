
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Database {

	private String db_isim;
	private String db_parola;
	
	public Database(String db_isim,String db_sifre) {
		this.db_isim = db_isim;
		this.db_parola = db_sifre;
	}
	
	
	public java.sql.Connection database_baglan() {
            try {
                String url = "jdbc:postgresql://localhost:5432/"+db_isim;
                Properties props = new Properties();
                props.setProperty("user","fred");
                props.setProperty("password","secret");
                props.setProperty("ssl","true");
                java.sql.Connection conn = DriverManager.getConnection(url, "postgres",db_parola);

                return conn;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
                return null;
        }
	
	public boolean kurs_aktiflestir(int kursId, String ogrenciTc) {
		
		try {
			
            java.sql.Connection conn = database_baglan();

            Statement st = conn.createStatement();
            ResultSet rs; 
            st.executeUpdate("UPDATE ogrenci_kurs SET durum=true WHERE kursid = "+kursId+" and "+"ogrencitc = '"+ogrenciTc+"'");
            //rs.close();
            
            rs = st.executeQuery("SELECT * FROM kurs WHERE kursid = "+String.valueOf(kursId));

            rs.next();
            int bulunanogrenciSayisi = rs.getInt(7);
            
            st.executeUpdate("UPDATE kurs SET bulunanogrencisayisi = "+String.valueOf(bulunanogrenciSayisi+1)+ "WHERE kursid = "+String.valueOf(kursId));
    		rs.close();
            
			st.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
/*	
public boolean kurs_bitir(int kursId, String ogrenciTc) {
		
		try {
			
            java.sql.Connection conn = database_baglan();

            Statement st = conn.createStatement();
            ResultSet rs; 
            st.executeUpdate("UPDATE ogrenci_kurs SET durum=false WHERE kursid = "+kursId+" and "+"ogrencitc = '"+ogrenciTc+"'");
            //rs.close();
            
            rs = st.executeQuery("SELECT * FROM kurs WHERE kursid = "+String.valueOf(kursId));

            rs.next();
            int bulunanogrenciSayisi = rs.getInt(7);
            
            st.executeUpdate("UPDATE kurs SET bulunanogrencisayisi = "+String.valueOf(bulunanogrenciSayisi-1)+ "WHERE kursid = "+String.valueOf(kursId));
    		rs.close();
            
			st.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	*/
	
	public Kurs kurs_getir(int kursid) {
		
		try {
	            java.sql.Connection conn = database_baglan();
	
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM kurs WHERE kursid = "+String.valueOf(kursid));
	
	            if(!rs.next()){
                        
                        rs.close();
                        st.close();
                        conn.close();
                        return null;
                    }
                    int kid = rs.getInt(1);
                    String kadi = rs.getString(2);
                    String kdili = rs.getString(3);
                    int ksinifi = rs.getInt(4);
                    int ksube = rs.getInt(5);
                    String kkurb = rs.getString(6);
                    int kogrencisayisi = rs.getInt(7);
                    String kogretmenid = rs.getString(8);
	            Kurs kurs = new Kurs(kid, kadi, kdili, ksinifi, ksube, kkurb, kogrencisayisi, kogretmenid);
	
	            rs.close();
	            st.close();
	            conn.close();
	            return kurs;
	        }catch(Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	        return null;
		
	}
	
	
	// Bu fonksiyon ile kurslar veriTaban�ndan �ekilebilir.Bu fonksiyondan al�nan de�erler arrayListe al�n�p listenebilir.
	// kurslar� arrayliste koyu d�nd�r�n�z.
	public ArrayList<Kurs> ingKurslariGetir() {
		try {
			
			java.sql.Connection conn = database_baglan();
			
			Statement sta = conn.createStatement(); 
		      ResultSet res = ((java.sql.Statement) sta).executeQuery("SELECT  * FROM kurs WHERE kursdili = 'İngilizce'");
                      ArrayList<Kurs> arr = new ArrayList<Kurs>();
		      System.out.println("Kurs Listesi");
		      while (res.next()) {
		    	// Veri taban�ndaki t�m kurs attributelar� bu �ekildedir.
                        Kurs kurs = new Kurs(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6),res.getInt(7),res.getString(8));
		    	arr.add(kurs);
		      }
                      res.close();
		      conn.close();
		      sta.close();
                      return arr;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
                return null;
	}
	
	public ArrayList<Kurs> almKurslariGetir() {
		try {
			
			java.sql.Connection conn = database_baglan();
			
			Statement sta = conn.createStatement(); 
		      ResultSet res = ((java.sql.Statement) sta).executeQuery("SELECT  * FROM kurs WHERE kursdili = 'Almanca'");
                      ArrayList<Kurs> arr = new ArrayList<Kurs>();
		      System.out.println("Kurs Listesi");
		      while (res.next()) {
		    	Kurs kurs = new Kurs(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6),res.getInt(7),res.getString(8));
		    	arr.add(kurs);
		      }
                      res.close();
		      conn.close();
		      sta.close();
                      return arr;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
                return null;
	}
	
	
	// Bu fonksiyon ile verilen tc numar�s�na g�re ��renci d�nd�r�l�r.
	
	public Ogrenci ogrenciGetir(String id) {
		try {
			
                    java.sql.Connection conn = database_baglan();

                    PreparedStatement st = conn.prepareStatement("SELECT * FROM ogrenci WHERE tc = '"+ id + "'");
                    ResultSet rs = st.executeQuery();
			
                    if(rs.next()){
                        String isim = rs.getString(1);
                        String soyisim = rs.getString(2);
                        String tc = rs.getString(3);
                        String telno= rs.getString(4);
                        Ogrenci ogr = new Ogrenci(isim,soyisim,tc,telno);

                        rs.close();
                        st.close();
                        conn.close();
                        return ogr;
                    }
                    else{
                        return null;
                    }
                    
		    
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null ;
		
	}
	
	// Bu fonksiyon Arraylist d�nd�recek �ekilde modifiye edilebilir.
	public ArrayList<Ogrenci> tumOgrencileriGetir() {
		try {
			
			java.sql.Connection conn =database_baglan();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ogrenci");
                        ArrayList<Ogrenci> arr = new ArrayList<Ogrenci>();
			
			while(rs.next()) {
			    String isim = rs.getString(1);
			    String soyisim = rs.getString(2);
			    String tc = rs.getString(3);
			    String telno= rs.getString(4);
			    Ogrenci ogr = new Ogrenci(isim,soyisim,tc,telno);
                            arr.add(ogr);
			    System.out.println(isim+" - "+ soyisim);
			}
			rs.close();
			st.close();
			conn.close();
                        return arr;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
                return null;
	}
	

// Taksit say�s� ve odeme bilgileri parametre olarak al�n�r.
	
public boolean ogrenci_ekle(Ogrenci ogrenci,Kurs kurs, int kampanyaId) {
		
    OdemeBilgisi odeme= new OdemeBilgisi();
    int sinifKapasitesi;
    int bulunanogrenciSayisi;

    try {
            java.sql.Connection conn = database_baglan();

            Statement st = conn.createStatement();
            ResultSet rs ;
            
            System.out.println("SELECT * FROM ogrenci WHERE tc = '"+ogrenci.getTc()+"'");
            rs = st.executeQuery("SELECT * FROM ogrenci WHERE tc = '"+ogrenci.getTc()+"'");
            
            
            if (!rs.next()) {
            	st.executeUpdate("INSERT INTO ogrenci(isim,soyisim,tc,telno) VALUES ('"+ogrenci.getIsim()+"','"+ogrenci.getSoyisim()+"','"+ogrenci.getTc()+"','"+ogrenci.getTelno()+"');");
                System.out.println("ogrenci eklendi");
                rs.close();
    		}
            else {
            	System.out.println("ogrenci zaten eklenmis");
            }
    		
            
            
            
            rs = st.executeQuery("SELECT * FROM kurs WHERE kursid = "+String.valueOf(kurs.getKursId()));

            rs.next();
            bulunanogrenciSayisi = rs.getInt(7);
            rs.close();
            System.out.println("asdasd");
            rs = st.executeQuery("SELECT * FROM sinif WHERE sinifid = "+String.valueOf(kurs.getSinif()));
            rs.next();
            sinifKapasitesi = rs.getInt(4);
            rs.close();
            
            if(sinifKapasitesi<=bulunanogrenciSayisi) { // sinif doludur eklenemez
            	st.close();
            	conn.close();
            	return false;
            }
            else { // yer vardir eklenebilir.
            	
            	if(kampanyaId==0) {
            		OdemeBilgisi kampanyasizOdeme = new OdemeBilgisi();
            		
            		kampanyasizOdeme.setOgrenciId(ogrenci.getTc());
            		kampanyasizOdeme.setBirimtaksitfiyat(500);
            		kampanyasizOdeme.setBorc_var_mi(true);
            		
            		rs = st.executeQuery("SELECT MAX(odemeid) FROM ogrenci_odeme ");
            		rs.next();
            		
            		int odemeId;
            		if (rs.wasNull()) {
            			odemeId = 1;
            		}
            		else {            			
            			odemeId = rs.getInt(1)+1;
            		}
            		rs.close();
            		kampanyasizOdeme.setOdemeId(odemeId);
            		kampanyasizOdeme.setOdenen_taksit_sayisi(0);
            		kampanyasizOdeme.setToplamfiyat(1500);
            		kampanyasizOdeme.setTaksit_sayisi(10);
            		
            		
            		st.executeUpdate("INSERT INTO  ogrenci_odeme VALUES ("+kampanyasizOdeme.getOdemeId()+", "+kampanyasizOdeme.getTaksit_sayisi()+", "+
            				kampanyasizOdeme.getOdenen_taksit_sayisi()+", "+kampanyasizOdeme.isBorc_var_mi()+", '"+kampanyasizOdeme.getOgrenciId()+"', "+kampanyasizOdeme.getToplamfiyat()+", "+kampanyasizOdeme.getBirimtaksitfiyat()+")");
                    	System.out.println("ogrenci_odeme eklenmistir");
            		
            		
            		st.executeUpdate("INSERT INTO ogrenci_kurs VALUES ('" + ogrenci.getTc() + "', "+kurs.getKursId()+", "+String.valueOf(kampanyasizOdeme.getOdemeId())+", "+0+",false"+")");
            		System.out.println("ogrenci_kurs eklenmistir");
       			 	
       			 	
            	}
            	else {    
            		
            		Kampanya kmp = kampanyaGetir(kampanyaId);  
            		int fiyat = kmp.getFiyat();
            		String[] alinanKursId = kmp.getAlinan_kurs_idler().split(","); 
            		String bedavaVerilneKursId = kmp.getBedava_verilen_kurs_id();
            		
            		rs = st.executeQuery("SELECT MAX(odemeid) FROM ogrenci_odeme ");
            		rs.next();
            		int id= rs.getInt(1);
            		
                    if(rs.wasNull()) 
                        id = 1;
                    else
                        id +=1;
                    
            		odeme.setOdemeId(id);
            		odeme.setTaksit_sayisi(10);
            		odeme.setOdenen_taksit_sayisi(0);
            		odeme.setBorc_var_mi(true);
            		odeme.setOgrenciId(ogrenci.getTc());
            		odeme.setToplamfiyat(fiyat);
            		odeme.setBirimtaksitfiyat(odeme.getToplamfiyat()/odeme.getTaksit_sayisi());
            		
            		rs.close();
            		
            		// 3. ogrenci_odeme tablosuna 1 satr ekle. +
            		st.executeUpdate("INSERT INTO ogrenci_odeme VALUES ("+odeme.getOdemeId()+", "+odeme.getTaksit_sayisi()+", "+
            		odeme.getOdenen_taksit_sayisi()+", "+odeme.isBorc_var_mi()+", '"+odeme.getOgrenciId()+"', "+odeme.getToplamfiyat()+", "+odeme.getBirimtaksitfiyat()+")");
            		System.out.println("ogrenci_odeme eklenmistir");
            		
            		// 1. ogrenci_kurs tablosuna kac ders aldysa ekle +
            		for(String i : alinanKursId) { // ogrenci_kurs tablosuna al�nan kurslar eklenir.
            			 st.executeUpdate("INSERT INTO ogrenci_kurs VALUES ('" + ogrenci.getTc() + "', "+(Integer.parseInt(i))+", "+String.valueOf(odeme.getOdemeId())+", "+kampanyaId+",false"+")");
            			 System.out.println("ogrenci_kurs eklenmistir");
            		}
            		
            		st.executeUpdate("INSERT INTO ogrenci_kurs VALUES ('" + ogrenci.getTc() + "', "+bedavaVerilneKursId+", "+String.valueOf(odeme.getOdemeId())+", "+kampanyaId+","+"false"+")");
            		System.out.println("ogrenci_kurs eklenmistir");
            		
            		
            	}
            	st.close();
            	conn.close();
            	return true;
            }
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
		
		return false;
	}


	public ArrayList<Kampanya> tumKampanyalariGetir() {
		try {
			
			java.sql.Connection conn = database_baglan();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM kampanya");
                        
                        ArrayList<Kampanya> arr = new ArrayList<Kampanya>();
			
			while(rs.next()) {
                                Kampanya kampanya = new Kampanya(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				arr.add(kampanya);
			}
			rs.close();
			st.close();
			conn.close();
                        return arr;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
                return null;
	}
	
	public ArrayList<OdemeBilgisi> odeme_bilgisi_getir(String tc) {

            ArrayList<OdemeBilgisi> arr = new ArrayList<OdemeBilgisi>();

            try {

                java.sql.Connection conn = database_baglan();
                Statement st = conn.createStatement();
                ResultSet rs;

                rs = st.executeQuery("SELECT * FROM ogrenci_odeme WHERE ogrencitc = '"+tc+"'");

                while(rs.next()) {

                    OdemeBilgisi ob = new OdemeBilgisi();

                    ob.setOdemeId(rs.getInt(1));
                    ob.setTaksit_sayisi(rs.getInt(2));
                    ob.setOdenen_taksit_sayisi(rs.getInt(3));
                    ob.setBorc_var_mi(rs.getBoolean(4));
                    ob.setOgrenciId(rs.getString(5));
                    ob.setToplamfiyat(rs.getInt(6));
                    ob.setBirimtaksitfiyat(rs.getInt(7));


                    arr.add(ob);

                }

                rs.close();
                st.close();
                conn.close();

                return arr;
            }
            catch (Exception e) {
                e.printStackTrace();

            }

            return null;
    }
	
	
	public Kampanya kampanyaGetir(int id) {
		try {
	
			java.sql.Connection conn = database_baglan();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM kampanya WHERE kampanyaid = "+String.valueOf(id));
			rs.next();
			int kampanyaid = rs.getInt(1);
			String kampanyaAdi = rs.getString(2);
			int fiyat = rs.getInt(3);
			String alinanKursIdler= rs.getString(4);
			String bedavaVerilenKursId = rs.getString(5);
		    
			Kampanya kmp = new Kampanya(kampanyaid,kampanyaAdi,fiyat, alinanKursIdler, bedavaVerilenKursId);
			
			rs.close();
			st.close();
			conn.close();
			return kmp;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
	public boolean kampanya_ekle(ArrayList<Integer> alinanKursIdler,int fiyat,String kampanyaAdi,int bedavaKursId) {

        String tmp = "";
        for(Integer i : alinanKursIdler) {
            tmp = tmp+i.toString()+",";
        }

        tmp = tmp.substring(0, tmp.length()-1);

        try {
            java.sql.Connection conn = database_baglan();

            Statement st = conn.createStatement();
            ResultSet rs;

            rs = st.executeQuery("SELECT MAX(kampanyaid) FROM kampanya");
            rs.next();

            int kampId;
            if (rs.wasNull()) {
                kampId= 1;
            }
            else {
                kampId = rs.getInt(1)+1;
            }

            rs.close();
            st.executeUpdate("INSERT INTO kampanya VALUES("+kampId+",'"+kampanyaAdi+"',"+fiyat+",'"+tmp+"','"+String.valueOf(bedavaKursId)+"')");

            conn.close();
            st.close();
            return true;

        }catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
	
	
	// Bu k�s�mda se�ilen kampanyaya g�re �grencinin kur bilgisi ve �deme bilgileri girilir.
	
	// arraylist olmal�
	public void kayitElemanlariniGetir() {
		try {
			java.sql.Connection conn = database_baglan();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM kayit_elemanlari");
			
			while(rs.next()) {
				String isim = rs.getString(1);
				String soyisim = rs.getString(2);
				String tc = rs.getString(3);
				String kullaniciadi= rs.getString(4);
				String sifre = rs.getString(5);
				
			    System.out.println(isim+" "+soyisim+" - "+sifre );		
			}
			rs.close();
			st.close();
			conn.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
        
        public ArrayList<Integer> alinanKurslariGetir(String ogrenciID){
            try {
			
                java.sql.Connection conn = database_baglan();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT kursid, durum FROM ogrenci_kurs WHERE ogrencitc = '"+ogrenciID+"'");
                
                ArrayList<Integer> arr = new ArrayList<Integer>();

                while(rs.next()) {
                    
                    if(!rs.getBoolean(2)){
                        System.out.println(rs.getInt(1));
                        arr.add(rs.getInt(1));
                    }
                    
                }
                rs.close();
                st.close();
                conn.close();
                return arr;
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        }
        
        public ArrayList<Integer> aktifKurslariGetir(String ogrenciID){
            try {
			
                java.sql.Connection conn =database_baglan();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT kursid, durum FROM ogrenci_kurs WHERE ogrencitc = '"+ogrenciID+"'");
                int i;
                ArrayList<Integer> arr = new ArrayList<Integer>();

                while(rs.next()) {
                    
                    if(rs.getBoolean(2)){
                        i = rs.getInt(1);
                        arr.add(i);
                    }
                    
                }
                rs.close();
                st.close();
                conn.close();
                return arr;
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        }
        
        public void taksitOde(int ID){
            try {
			
                java.sql.Connection conn =database_baglan();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * From ogrenci_odeme Where odemeid = '"+ID+"'");

                while(rs.next()) {
                    
                    if(rs.getInt(2) > rs.getInt(3)){
                        st.executeQuery("UPDATE ogrenci_odeme SET odenentaksitsayisi = odenentaksitsayisi +1 WHERE odemeid = '"+ID+"'");
                    }
                    
                }
                rs.close();
                st.close();
                conn.close();
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        
}
