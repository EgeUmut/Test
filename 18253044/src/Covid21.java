public class Covid21 extends Virus {

    public Covid21(String ad, double bulasmaMiktari, double guc){

        super(ad,bulasmaMiktari,guc);
    }

    @Override
    public void mutasyonaUgra(Virus other) {
        if(other instanceof Covid21) this.guc *= 3;

    }

    @Override
    public boolean hastaEdiyormu(Canli other) {
        if(other instanceof Insan||  other instanceof Karincayiyen)
            return true;
        else
            return false;
    }




}

