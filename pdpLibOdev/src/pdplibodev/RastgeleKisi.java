/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdplibodev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RastgeleKisi
{
   
    public static String rastgeleKisiUret() throws IOException  //Random_isimler.txt dosyasından rastgele isim cek
    {
       
        Random rnd = new Random();
        
        int sayi=rnd.nextInt(3004);
        
        String satir="";
        
        BufferedReader oku = new BufferedReader(new FileReader("random_isimler.txt"));
       
        //Random bulunan degerde fonksiyon sona erir o ismi alır
        for (int i = 0; i < sayi; i++)
        {
            satir=oku.readLine();
        }
    
        return satir;
       
    } 

}
