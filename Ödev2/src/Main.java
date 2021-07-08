

import java.util.Random;

public class Main {

    public static void main(String[] args) {



        System.out.println("Main Thread Çalışıyor!\n");

        Thread [] threadler = new Thread[10];
        for(int i = 0; i <10; i++){
            threadler[i] = new Thread(new IlkThread(i));
        }

        for(int i = 0; i < 10; i++){
            threadler[i].start();
            try{
                threadler[i].join();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        // threadlerin rastgele çalışması isteniyorsa burası kullanılmalı

        //  Thread ilk = new Thread(new IlkThread("0"));
        //    ilk.start();
  /*      try{
             // ilk.join();
            for (int i = 0; i < 10; i++){
                threadler[i].join();  // bekletme kısmı
            }
        }
        catch(Exception e){
            System.out.println(e);
        }*/
        System.out.println("Tum Elemanların Toplamı = " + IlkThread.sum + " Olur!");
        System.out.println("Main Thread Kapanıyor!\n");

    }

}
