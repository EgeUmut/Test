import java.util.Random;
public class IlkThread implements Runnable{

    public int id;
    public static int sum;
    int count = 0;

    int array[] = new int[10000];

    public IlkThread(int id){
        this.id = id;
    }



    @Override
    public void run(){
     /*   int toplam = 0;
        for(int i =0; i<1000; i++){
            Random a = new Random();
            int b = a.nextInt(1000-0) + 0;
            toplam = toplam + b;
        }*/

     int toplam[] = new int[10];
     if(count == 0){
         for (int i = 0; i <10000 ; i++) {
             Random a = new Random();
             array[i] = a.nextInt(1000 - 0) + 0;
         }
         for (int i = 0; i <1000; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     if(count == 1){
         for (int i = 1000; i <2000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 2){
         for (int i = 2000; i <3000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 3){
         for (int i = 3000; i <4000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 4){
         for (int i = 4000; i <5000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 5){
         for (int i = 5000; i <6000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 6){
         for (int i = 6000; i <7000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 7){
         for (int i = 7000; i <8000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 8){
         for (int i = 8000; i <9000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }
     else if(count == 9){
         for (int i = 9000; i <10000 ; i++) {
             toplam[count] = toplam[count] + array[i];
         }
     }

        sum += toplam[count];
        System.out.println("Bu Threadin id si " + id + " ve 1000 elemanın toplamı = " + toplam[count] + " olmaktadır");
        count++;
        try {

        }
        catch (Exception e){
           // System.out.println(e);
        }
      /*  if(id == 9){
            System.out.println("Tüm elemanların toplamı = " + sum + " olur!");
        }
        Main kek = new Main(sum);*/
        //System.out.println(yeni.Oku());
        //System.out.println("Hello, I am Thread " + id + " Good Bye\n");
    }
}
