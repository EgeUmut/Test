public abstract class Virus implements Comparable {

    public String ad;
    public double bulasmaMiktari;
    public double guc;

    public Virus(String ad, double bulasmaMiktari, double guc)
    {
        this.ad = ad;
        this.bulasmaMiktari = bulasmaMiktari;
        this.guc = guc;

    }
    public Virus (Virus virusObj)
    {
        this.ad = virusObj.ad;
        this.bulasmaMiktari = virusObj.bulasmaMiktari;
        this.guc = virusObj.guc;

    }
    public int compareTo(Object o) {
        if(this.getClass() == o.getClass()) return 1;
        else return 0;

    }
    public abstract void mutasyonaUgra(Virus other);
    public abstract boolean hastaEdiyormu(Canli other);
}
