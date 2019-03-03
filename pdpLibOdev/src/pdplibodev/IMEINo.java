
package pdplibodev;

import java.util.Random;

public class IMEINo {
     
    public static String imeiUret()  //IMEI numarasını uret
    {
    
        String imeiNo="";

        int[] imei=new int[15];
        
        for (int i = 0; i < 14; i++) //14 haneye random rakam atarız
        {
        
            Random rand = new Random();
            
            imei[i]=rand.nextInt(10);
            
        }
        
        int tekTop=0,ciftler=0;
        
        for (int i = 0; i < 14; i++) 
        {
        
            if(i%2==0) tekTop+=imei[i];  //Tek hane kontrolu
            
            if(i%2==1) ciftler+= (imei[i]*2)%10 + (imei[i]*2)/10; //Cift hanelerin kontrol islemi
            
        }
        
        imei[14]=10-(tekTop+ciftler)%10;  //15.haneyi bulup diziye atama yaptık
        
        for (int i = 0; i < 15; i++) {
        
            imeiNo+=imei[i];
            
        }
        
        return imeiNo;
    }
    
    
    public static boolean imeiKontrol(String imei)
    {

        boolean onay=true;
        
        int[] imeidizi=new int[15];
        
        for (int i = 0; i < 15; i++) 
        {
            //IMEI adresini string olarak alıp substring ile bölerek integer diziye atarız
            imeidizi[i] = Integer.parseInt(imei.substring(i, i+1 ));
            
        }
        
        int tekTop=0,ciftler=0;
        
        for (int i = 0; i < 14; i++) 
        {
        
            if(i%2==0) tekTop+=imeidizi[i];  //Tek basamaklar topla
            
            if(i%2==1) ciftler+= (imeidizi[i]*2)%10 + (imeidizi[i]*2)/10; // cift basamak islemi
            
        }
        
        if(imeidizi[14]!=(10-(tekTop+ciftler)%10)) onay=false;  // son basamak kurala uyuyormu uymuyormu
        
        return onay;
    }
}
