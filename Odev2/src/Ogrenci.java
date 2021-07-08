import java.io.Serializable;

public class Ogrenci implements Serializable
        {
        public String OgrenciNo;
        public String OgrenciAd;
        public String OgrenciSoyad;
        public String OgrenciBolum;
        public Ogrenci(String OgrenciNo, String OgrenciAd, String OgrenciSoyad, String OgrenciBolum){
            this.OgrenciNo = OgrenciNo;
            this.OgrenciAd = OgrenciAd;
            this.OgrenciSoyad = OgrenciSoyad;
            this.OgrenciBolum = OgrenciBolum;
        }

        @Override
        public String toString() {
            return OgrenciNo+" "+OgrenciAd+" "+OgrenciSoyad+" "+OgrenciBolum;
        }


}
