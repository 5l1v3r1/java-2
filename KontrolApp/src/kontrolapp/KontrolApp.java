
package kontrolapp;
import java.util.*;
import  java.io.*;
import pdplibodev.*;



public class KontrolApp {

 
    public static void main(String[] args) throws IOException
    {
        Kisi kisi=new Kisi();
      
        int secim;
        System.out.println("1- Rastgele Kişi Üret");
        System.out.println("2- Üretilmiş Dosya Kontrol Et");
        System.out.println("3- Çıkış");
        Scanner i = new Scanner(System.in);
    
        secim= i.nextInt();
    
    switch(secim){ 
        case 1:
            kisi.kisiUret();
            break;
        case 2:
            kisi.kisiKontrol();
            break;
        case 3:    
    
        default: System.out.println("Hatalı Seçim");break;
    }
    
    
    
    }
    
    
}
