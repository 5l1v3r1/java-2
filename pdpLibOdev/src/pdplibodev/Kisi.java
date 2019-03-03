
package pdplibodev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Kisi
{
    public KimlikNo tcNo;
    public RastgeleKisi isim;
    public int yas;
    public Telefon telefon;
    public IMEINo imei;
    //Getter ve Setter komutlarımız
    
    public RastgeleKisi getAd ( ) 
    {
    return isim;
    }
    
    public void setAd(RastgeleKisi isim ) 
    {
    this.isim = isim;
    }
   
  
    public KimlikNo getTcNo() 
    {
        return tcNo;
    }

    public void setTcNo(KimlikNo tcNo) 
    {
        this.tcNo = tcNo;
    }

    public int getYas() 
    {
        Random rand = new Random();
        yas=rand.nextInt(100);
        return yas;
    }

    public void setYas(int yas) 
    {
        this.yas = yas;
    }

    public Telefon getTelefon() 
    {
        return telefon;
    }

    public void setTelefon(Telefon telefon) 
    {
        this.telefon = telefon; 
    }

    public IMEINo getImei() 
    {
        return imei;
    }

    public void setImei(IMEINo imei) 
    {
        this.imei = imei;
    }
    //Kisi üretmek için kullandıgımız fonksiyon
    public void kisiUret()
    {
    try
        {
            BufferedWriter yaz = new BufferedWriter(new FileWriter("kisiler.txt",true));
            
            yaz.write(tcNo.TCUret()+ " " + RastgeleKisi.rastgeleKisiUret()+  " " + getYas() + " " + telefon.telefonUret() +  " " +   imei.imeiUret()  + "\n");
            
            yaz.newLine();
            
            yaz.close();
            
            System.out.println("Ekleme İşlemi Başarılı");
        }
        
    catch (Exception hata)
        {
            hata.printStackTrace();
        }
    }
    public void kisiKontrol() throws FileNotFoundException, IOException
    {
    
        KimlikNo kimlik=new KimlikNo();
        
        IMEINo imei=new IMEINo();
        
        int gecerli=0,gecersiz=0,gecerliTc=0,gecersizTc=0;
        
        BufferedReader oku = new BufferedReader(new FileReader("kisiler.txt"));
        
        String[] dizi = null;
        
        String satir="";
        do {
            satir=oku.readLine();
            if (satir!=null) {
                dizi = satir.split(" "); 
                
                if(KimlikNo.TCKontrol(dizi[0]))//Tc kontrol çağrılır doğru ise kontrol degiskeni arttırılır
                {
                    gecerliTc++;
                }
                 else    //Aksi durumda ise negatif durum degiskenini arttırırız
               {
             
                 gecersizTc++;
               }
                if(IMEINo.imeiKontrol(dizi[5]))//imeiKontrol çağrılır doğru ise kontrol degiskeni arttırılır
                {
                
                  gecerli++;
               }
              else   //Aksi durumda ise negatif durum degiskenini arttırırız
              {
              
                  gecersiz++;
              }
            } 
              
        } while (oku.readLine()!=null);
         oku.close();   //Dosya kapa
         
         System.out.println("T.C. Kimlik Kontrol\n"+gecerliTc+"   Gecerli");
         
         System.out.println(gecersizTc+"Gecersiz\n");
         
         System.out.println("IMEI Kontrol:\n "+ gecerli+"    Gecerli");
         
         System.out.println(gecersiz+"Gecersiz");
      
    }
    }
    
    
 

