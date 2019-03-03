/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdplibodev;

import java.util.Random;

/**
 *
 * @author Hasan
 */
public class Telefon 
{
        public static String telefonUret()
        {
        
            String gsmNo="";
            //Turkiye icin gsm kodlarını string dizisine atadık
            String[] gsmKod= {"0531","0532","0533","0534","0535","0536","0537","0538","0539",
            "0541","0542","0543","0544","0545","0546",
            "0505","0506","0507",
            "0551","0552","0553","0554","0555","0556","0557","0558","0559"};
        
       
            Random rand=new Random(); //Random sayı icin rand referans
        
            gsmNo=gsmKod[rand.nextInt(27)];  //Random olarak seceriz
            
            for (int i = 0; i < 7; i++)  //Kalan basamaklara rakam atarız 
            {
            
                Random rand2=new Random();  //Random sayı icin rand referans
            
                gsmNo+=rand2.nextInt(10);  //Rakamlar numaranın sonuna eklenerek numarayı olustururuz
                
            }
        
            return gsmNo;
        }
}
