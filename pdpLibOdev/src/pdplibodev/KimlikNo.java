package pdplibodev;

import java.util.Random;

public class KimlikNo {
    
    public static String TCUret(){
    
        String tcno = "";
    
        int[] tc = new int[11];
    
        for (int i=0; i<9 ; i++)
        {
    
            Random rand = new Random();  //Random sayı için kullanacağız
     
            tc[i]=rand.nextInt(10);
      
            while (tc[0]==0)  //Tc kimlik numarasının ilk hanesi sıfır ise farklı rakamlar atanır
            {
            
                rand = new Random(); 
    
                tc[0]= rand.nextInt(10);
            
            }
         
         }
         int tekTop=0;
         int ciftTop=0;
         int sonhane;
         
         for(int i=0; i<9; i++)
         {
         if (i%2==0)
       
             tekTop+=tc[i];  //Tc kimlik numarasının içindeki tek haneler toplanır
         if(i%2==1)
       
             ciftTop+=tc[i];  //Tc kimlik numarası içindeki çift haneler toplanır
        
         }
   
        tc[9]=(tekTop*7-ciftTop)%10;  // 10.hane hesaplama kuralımız
        
        int toplam=0;
        
        for (int i = 0; i < 10; i++) 
       
        {
                  
                  toplam+=tc[i];  //
       
        }
     
        tc[10]=toplam%10;    //11. Hane kuralımız
    
        for (int i = 0; i < 11; i++) 
    
        {
                  tcno+=tc[i];  //Kimlik numarası string degiskene atanır
      
        }
        return tcno;  
    }
    
    public static boolean TCKontrol(String tc)  //Tc kontrolü için kullanacağımız fonksiyon
    {
        boolean onay=true;  //Boolen default true atadık
        int[] tcdizi=new int[11];
        int tekTop=0,ciftTop=0;
                
        for (int i = 0; i < 11; i++) 
        {
        
            tcdizi[i] = Integer.parseInt(tc.substring(i, i+1 ));  
            // Tc yi string olarak alıp substring metodu ile bölerek integer dizisine atadık
      
        }
       
        if(tcdizi[0]==0) onay= false;
        
        for (int i = 0; i < 9; i++) 
        {
      
            if (i%2==0)//tek ise
    
                tekTop+=tcdizi[i];
    
            if (i%2==1)//Çift ise
    
                ciftTop+=tcdizi[i];
    
        }
      
        if((tekTop*7-ciftTop)%10!=tcdizi[9]) onay=false;  //Kurala uymaz ise
      
        if((tekTop+ciftTop+tcdizi[9])%10!=tcdizi[10]) onay=false;  //Kurala uymaz ise
        
        
        return onay;
    }
           
}
