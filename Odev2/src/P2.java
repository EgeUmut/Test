import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.ServerSocket;

public class P2 {

    public static void main(String[] args) throws Exception
    {

    Socket socket = new Socket("127.0.0.1" , 9090);

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

/*
        Ogrenci test = new Ogrenci("15", "Ayse", "Gül", "Bilgisayar");
        outStream.writeObject(test);

        Ogrenci recvOgrenci = (Ogrenci)inStream.readObject();
        System.out.println(recvOgrenci.toString());
*/
        Ogrenci recvOgrenci = (Ogrenci)inStream.readObject();
        System.out.println(recvOgrenci.toString());

            recvOgrenci.OgrenciAd = "Ali";
            outStream.writeObject(recvOgrenci);


        outStream.close();
        socket.close();
    }
}