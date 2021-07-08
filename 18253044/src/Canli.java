import java.util.ArrayList;
import java.util.Collections;
public class Canli implements Comparable{

    public String ad;
    public int yas;
    public ArrayList<Virus> kVirusler;

    private ArrayList<String> infectedViruses = new ArrayList<String>();
    private ArrayList<String> existingViruses = new ArrayList<String>();
    private double sumBm; //Bulaşma miktarı toplamı
    private double avarageBm; //Bulaşma miktarı ortalama
    private int sameVirusCount;

    public Canli(String ad, int yas){
        this.ad = ad;
        this.yas = yas;
        this.kVirusler = new ArrayList<Virus>();
    }

    @Override
    public int compareTo(Object o) {

        if(this.equals(o)) return 1;
        else return 0;

    }
    public String getAd()
    {
        return this.ad;
    }
    public int getYas()
    {
        return this.yas;
    }
    public ArrayList<Virus> getkVirusler()
    {
        return this.kVirusler;
    }
    public void setAd(String ad)
    {
        this.ad = ad;
    }
    public void setYas(int yas)
    {
        this.yas = yas;
    }
    public void setkVirusler(ArrayList<Virus> kVirusler)
    {
        this.kVirusler = kVirusler;
    }

    public void hastalikKap(ArrayList<Virus> virusler){
        existingViruses.clear();
        infectedViruses.clear();
        sumBm = 0;
        sameVirusCount = 0;
        int a = 0;
        //Eğer virüs canlıyı hasta ediyorsa ve o virüs türünden listede başka varsa hepsi bulunup ortalaması alınıyor.
        for (int i = 0; i < virusler.size() ; i++ )
        {
            if(virusler.get(i).hastaEdiyormu(this) && !infectedViruses.contains(virusler.get(i).getClass().getName()))
            {
                //Canlıda bulunan virüs türleri String türünde bir listeye alınıyor
                existingViruses.clear();
                existingViruses =  getExistingViruses(this);
                sameVirusCount = 0;
                sumBm = 0;
                //Listedeki diğer virusler kontrol ediliyor aynı virüs türünden var mı diye
                for (int j = 0 ; j < virusler.size(); j++ )
                {
                    if(virusler.get(j).compareTo(virusler.get(i)) == 1)
                    {
                        sameVirusCount++;;
                        sumBm += virusler.get(j).bulasmaMiktari;
                    }
                }
                avarageBm = sumBm / sameVirusCount;
                Virus newVirus = new Covid19("TEMP",0,0);
                if(virusler.get(i) instanceof Covid19)
                    newVirus = new Covid19("C19new", avarageBm, 5);

                else if(virusler.get(i) instanceof Covid20)
                    newVirus = new Covid20("C20new", avarageBm, 5);

                else if(virusler.get(i) instanceof Covid21)
                    newVirus = new Covid21("C21new", avarageBm, 5);

                //Virüs kVirusler listesinde yoksa yeni
                if(!existingViruses.contains(virusler.get(i).getClass().getName()))
                {
                    this.kVirusler.add(newVirus);
                    infectedViruses.add(newVirus.getClass().getName());
                }
                else
                {
                    int k;
                    //kVirusler listesindeki mevcut olan virus objesi bulundu - this.kVirusler.get(k)
                    for (k = 0; k < this.kVirusler.size() ; k++ )
                    {
                        if(this.kVirusler.get(k).compareTo(virusler.get(i)) == 1)
                        {
                            sameVirusCount++;
                            sumBm += this.kVirusler.get(k).bulasmaMiktari;
                            a = k;
                            break;
                        }
                    }
                    avarageBm = sumBm / sameVirusCount;
                    this.kVirusler.get(a).bulasmaMiktari = avarageBm;
                    infectedViruses.add(this.kVirusler.get(a).getClass().getName());
                }
            }

        }

    }

    public void hastalikKapv2(ArrayList<Canli> canlilar){
        existingViruses.clear();
        infectedViruses.clear();
        int x,a = 0;
        for (x = 0; x < canlilar.size() ; x++)
        {
            if(this instanceof Karinca && canlilar.get(x) instanceof Karincayiyen)
            {
                ((Karinca) this).kYiyenSayisi++;
            }
            else if(canlilar.get(x) instanceof Karinca)
            {
                for (int k = 0;k < canlilar.size() ;k++ )
                {
                    if(canlilar.get(k) instanceof Karincayiyen)
                    {
                        ((Karinca) canlilar.get(x)).kYiyenSayisi++;
                    }
                }
            }
            sumBm = 0;
            sameVirusCount = 0;
            int i,j;
            for (i = 0; i < canlilar.get(x).kVirusler.size() ; i++ )
            {
                if(canlilar.get(x).kVirusler.get(i).hastaEdiyormu(this) && !infectedViruses.contains(canlilar.get(x).kVirusler.get(i).getClass().getName()))
                {
                    //Aynı virüs türlerini bulabilmek için diziye atılıyor
                    existingViruses.clear();
                    existingViruses =  getExistingViruses(this);
                    sameVirusCount = 0;
                    sumBm = 0;
                    //Tüm canlılardaki virusler kontrol ediliyor aynı virüs türünden var mı diye
                    for (int n=0; n< canlilar.size() ;n++ )
                    {
                        for (int m = 0;m < canlilar.get(n).kVirusler.size() ;m++ )
                        {

                            if(canlilar.get(n).kVirusler.get(m).compareTo(canlilar.get(x).kVirusler.get(i)) == 1)
                            {
                                sameVirusCount++;
                                sumBm += canlilar.get(n).kVirusler.get(m).bulasmaMiktari;
                            }
                        }
                    }

                    avarageBm = sumBm / sameVirusCount;
                    Virus newVirus = new Covid19("TEMP",0,0);
                    if(canlilar.get(x).kVirusler.get(i) instanceof Covid19)
                        newVirus = new Covid19("C19new", avarageBm, 10.0);

                    else if(canlilar.get(x).kVirusler.get(i) instanceof Covid20)
                        newVirus = new Covid20("C20new", avarageBm, 10.0);

                    else if(canlilar.get(x).kVirusler.get(i) instanceof Covid21)
                        newVirus = new Covid21("C21new", avarageBm, 10.0);

                    if(!existingViruses.contains(canlilar.get(x).kVirusler.get(i).getClass().getName()))
                    {
                        this.kVirusler.add(newVirus);
                        infectedViruses.add(newVirus.getClass().getName());
                    }
                    else
                    {
                        //kVirusler listesindeki mevcut olan virus objesi bulundu - this.kVirusler.get(k)
                        for (int k = 0; k < this.kVirusler.size() ; k++ )
                        {
                            if(this.kVirusler.get(k).compareTo(canlilar.get(x).kVirusler.get(i)) == 1)
                            {
                                sameVirusCount++;
                                sumBm += this.kVirusler.get(k).bulasmaMiktari;
                                infectedViruses.add(this.kVirusler.get(k).getClass().getName());
                                a = k;
                                break;
                            }
                        }
                        avarageBm = sumBm / sameVirusCount;
                        this.kVirusler.get(a).bulasmaMiktari = avarageBm;
                        infectedViruses.add(this.kVirusler.get(a).getClass().getName());
                    }


                }
            }
        }
    }
    public void hastalikKap(Canli[] canlilar)
    {

        for (int z = 0;z < canlilar.length ;z++ )
        {
            if(canlilar[z] instanceof Karinca)
            {
                for (int i=0;i < canlilar.length ;i++ )
                {
                    if(canlilar[i] instanceof Karincayiyen) ((Karinca) canlilar[z]).kYiyenSayisi++;
                }
            }
        }
        existingViruses.clear();
        infectedViruses.clear();
        ArrayList<Double>[] bmFirst = new ArrayList[canlilar.length];
        for (int i= 0;i < bmFirst.length ;i++ ) bmFirst[i] = new ArrayList<Double>();
        ArrayList<Virus>[] eklenecekler = new ArrayList[canlilar.length];
        for(int i=0;i < eklenecekler.length; i++) eklenecekler[i] = new ArrayList<Virus>();
        for (int i=0;i< canlilar.length ;i++ )
        {
            for (int j= 0;j < canlilar[i].kVirusler.size() ;j++ )
            {
                bmFirst[i].add(canlilar[i].kVirusler.get(j).bulasmaMiktari);
            }
        }
        int z;
        for (z = 0;z < canlilar.length ; z++ )
        {

            infectedViruses.clear();
            int x,a = 0;
            for (x = 0; x < canlilar.length ; x++)
            {

                if(x != z)
                {
                    sumBm = 0;
                    sameVirusCount = 0;
                    int i,j;
                    for (i = 0; i < canlilar[x].kVirusler.size() ; i++ )
                    {
                        if(canlilar[x].kVirusler.get(i).hastaEdiyormu(canlilar[z]))
                        {
                            //canlilar[z]'deki bulunan virüs türleri alınıyor. boyutu en fazla 3 olacağından bu list içinde aramak daha hızlı oluyor canlilarr[z].kVirusler içinde aramaktansa
                            existingViruses.clear();
                            existingViruses = getExistingViruses(canlilar[z]);
                            //Eğer virusler.get(i) virüsü canlıda yoksa
                            if(!infectedViruses.contains(canlilar[x].kVirusler.get(i).getClass().getName()) && !existingViruses.contains(canlilar[x].kVirusler.get(i).getClass().getName()))
                            {
                                sameVirusCount = 0;
                                sumBm = 0;
                                //Tüm canlılardaki virusler kontrol ediliyor aynı virüs türünden var mı diye
                                int n,m;
                                for (n=0; n < canlilar.length ;n++ )
                                {
                                    if(n != z)
                                    {
                                        for (m = 0;m < canlilar[n].kVirusler.size() ;m++ )
                                        {

                                            if(canlilar[n].kVirusler.get(m).compareTo(canlilar[x].kVirusler.get(i)) == 1)
                                            {
                                                sameVirusCount++;
                                                //bmOrt += canlilar[n].kVirusler.get(m).bulasmaMiktari;
                                                sumBm += bmFirst[n].get(m);
                                            }
                                        }
                                    }

                                }

                                avarageBm = sumBm / sameVirusCount;
                                Virus newVirus;
                                if(canlilar[x].kVirusler.get(i) instanceof Covid19)
                                {
                                    newVirus = new Covid19("covid19", avarageBm, 10.0);
                                    //canlilar[z].kVirusler.add(newVirus);
                                    eklenecekler[z].add(newVirus);
                                    infectedViruses.add(newVirus.getClass().getName());
                                }
                                else if(canlilar[x].kVirusler.get(i) instanceof Covid20)
                                {
                                    newVirus = new Covid20("covid20", avarageBm, 10.0);
                                    //canlilar[z].kVirusler.add(newVirus);
                                    eklenecekler[z].add(newVirus);
                                    infectedViruses.add(newVirus.getClass().getName());
                                }
                                else if(canlilar[x].kVirusler.get(i) instanceof Covid21)
                                {
                                    newVirus = new Covid21("covid21", avarageBm, 10.0);
                                    //canlilar[z].kVirusler.add(newVirus);
                                    eklenecekler[z].add(newVirus);
                                    infectedViruses.add(newVirus.getClass().getName());
                                }

                            }
                            else if(!infectedViruses.contains(canlilar[x].kVirusler.get(i).getClass().getName()) && existingViruses.contains(canlilar[x].kVirusler.get(i).getClass().getName()))
                            {
                                int k;
                                sameVirusCount = 0;
                                sumBm = 0;
                                //kVirusler listesindeki mevcut olan virus objesi bulundu - this.kVirusler.get(k)
                                for (k = 0; k < canlilar[z].kVirusler.size() ; k++ )
                                {
                                    if(canlilar[z].kVirusler.get(k).compareTo(canlilar[x].kVirusler.get(i)) == 1)
                                    {
                                        sameVirusCount++;
                                        sumBm += bmFirst[z].get(k);
                                        if(!infectedViruses.contains(canlilar[z].kVirusler.get(k).getClass().getName())) infectedViruses.add(canlilar[z].kVirusler.get(k).getClass().getName());
                                        a = k;
                                        break;

                                    }
                                }
                                //Virusler içindeki aynı virüsler bulunup bulaşma miktarları alınıyor
                                int y;
                                for (y = 0; y < canlilar.length; y++ )
                                {
                                    if(y != z)
                                    {
                                        for (j = 0; j < canlilar[y].kVirusler.size(); j++ )
                                        {
                                            if(canlilar[y].kVirusler.get(j).compareTo(canlilar[z].kVirusler.get(a)) == 1)
                                            {
                                                sameVirusCount++;
                                                sumBm += bmFirst[y].get(j);
                                            }
                                        }
                                    }
                                }
                                avarageBm = sumBm / sameVirusCount;
                                canlilar[z].kVirusler.get(a).bulasmaMiktari = avarageBm;
                                infectedViruses.add(canlilar[z].kVirusler.get(a).getClass().getName());

                            }
                        }
                    }
                }
            }
        }
        for (int i = 0;i < canlilar.length ;i++ )
        {
            for(int j = 0; j < eklenecekler[i].size(); j++)
            {
                canlilar[i].kVirusler.add(eklenecekler[i].get(j));
            }
        }
    }
    private ArrayList<String> getExistingViruses(Canli other)
    {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0;i < other.kVirusler.size() ;i++ )
        {
            temp.add(other.kVirusler.get(i).getClass().getName());
        }
        return temp;
    }
}
