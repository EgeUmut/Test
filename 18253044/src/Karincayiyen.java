import java.util.ArrayList;

public class Karincayiyen extends Canli {

    public Karincayiyen(String ad, int yas) {

        super(ad,yas);

    }

    public void karincaYe(ArrayList<Karinca> karincalar){
        ArrayList<String> bulunanlar = new ArrayList<String>();
        boolean varMi = false;
        for (int i = 0; i < karincalar.size() ; i++ )
        {
            karincalar.get(i).kYiyenSayisi++;
            bulunanlar.clear();
            for (int l = 0;l < this.kVirusler.size() ;l++ )
            {
                if(!bulunanlar.contains(this.kVirusler.getClass().getName())) bulunanlar.add(this.kVirusler.getClass().getName());
                if(bulunanlar.size() == 3) break;
            }
            for (int j = 0; j < karincalar.get(i).kVirusler.size() ; j++ )
            {
                //karincalar.get(i).kVirusler.get(j) virus türü var mı??
                if(!bulunanlar.contains(karincalar.get(i).kVirusler.get(j).getClass().getName()))
                {
                    karincalar.get(i).kYiyenSayisi++;
                    Covid20 yeniVirusKarinca = new Covid20("virus",10,10);
                    this.kVirusler.add(yeniVirusKarinca);
                }
            }
        }




    }

}
