import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class P1 {


    public static void main(String[] args) throws Exception
    {




        Ogrenci test = new Ogrenci("15", "Ayse", "Gül", "Bilgisayar");



        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server " + 9090 + " portunda çalışıyor !");
        Socket socket = serverSocket.accept(); // clientla bağlantıyı bekler

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

        outStream.writeObject(test);

        Ogrenci aliOgrenci = (Ogrenci)inStream.readObject();
        System.out.println(aliOgrenci.toString());

/*
        Ogrenci al = (Ogrenci)inStream.readObject();
        System.out.println(al.toString());

        if(al.OgrenciAd == "Ayse"){
            al.OgrenciAd = "Ali";
            outStream.writeObject(al);
        }*/
    serverSocket.close();



    }
}