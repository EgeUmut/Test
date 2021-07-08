public class Covid19 extends Virus{

    public Covid19(String ad, double bulasmaMiktari, double guc){
        super(ad,bulasmaMiktari,guc);

    }
    @Override
    public void mutasyonaUgra(Virus other) {
        if(other instanceof Covid21) this.guc *= 2;

    }

    @Override
    public boolean hastaEdiyormu(Canli other) {

        if(other instanceof Insan)
            return true;
        else
            return false;
    }


}
