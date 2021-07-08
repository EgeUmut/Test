import java.util.ArrayList;
public class Insan extends Canli {


    String meslek;
    Canli[] canlilar;
    public Insan(String ad, int yas, String meslek) {
        super(ad,yas);
        this.meslek = meslek;
        canlilar = new Canli[0];


    }

    public  void hastalikKapv2(ArrayList<Canli> canlilar2){
        //Parametre ile gelen canlilar2 listesinde this nesnesinin birlikte yaşadığı canlılardan varsa onlar çıkarılıyor listeden
        ArrayList<Canli> canlilar3 = new ArrayList<Canli>();
        if(canlilar != null)
            for (int i=0;i < canlilar2.size() ;i++ )
            {    boolean found=false;
                for (int j=0;j < canlilar.length ;j++ )
                {
                    if(canlilar[j] ==canlilar2.get(i))
                        found=true;


                }
                if(!found)
                    canlilar3.add(canlilar2.get(i));
            }
        super.hastalikKapv2(canlilar3);
    }






}
