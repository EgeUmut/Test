public class Covid20 extends Virus {


    public Covid20(String ad, double bulasmaMiktari, double guc){

        super(ad,bulasmaMiktari,guc);

    }

    @Override
    public void mutasyonaUgra(Virus other) {

    }

    @Override
    public boolean hastaEdiyormu(Canli other) {
        if(other instanceof Insan || other instanceof Karinca || other instanceof Karincayiyen)
            return true;
        else
            return false;
    }


}