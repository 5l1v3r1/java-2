/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdplibodev;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hasan
 */
public class PdpLibOdev 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        KimlikNo tc = new KimlikNo();
        Telefon telefon = new Telefon();
        IMEINo imei = new IMEINo();
        RastgeleKisi rastgeleKisi = new RastgeleKisi();
        Kisi kisi = new Kisi();
       // kisi.setAd(rastgeleKisi.rastgeleKisiUret());
        
        try
        {
          /*  File dosya = new File("Kisiler.txt");
            FileWriter yazici = new FileWriter(dosya,false);*/
            BufferedWriter yaz = new BufferedWriter(new FileWriter("kisiler.txt",true));
            yaz.write(tc.TCUret()+ " " + kisi.getAd()+  " " + kisi.getYas() + " " + telefon.telefonUret() +  " " +   imei.imeiUret()  + "\n");
            yaz.newLine();
            yaz.close();
            System.out.println("Ekleme İşlemi Başarılı");
        }
        catch (Exception hata)
        {
            hata.printStackTrace();
        }
    }
    
}
