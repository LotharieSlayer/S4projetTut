package TwistLock.network;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Socket qui se connectera à chaque Serveur de chaque robot.
 */

 //emetteur
public class SocketR implements Closeable{
    
    private final static int PORT = 1312;

    private String message;
    private InetAddress mcast;
    private static MulticastSocket ms;

    public SocketR() {
        try {
            ms = new MulticastSocket();
            mcast  = InetAddress.getByName("225.1.1.1");
        } catch (IOException e) {e.printStackTrace();}
    }

    public void setMessage(String message) {
        this.message = "TwistLock:"+message;
    }

    public void sendMessage() throws IOException{
        DatagramPacket dp  = new DatagramPacket(message.getBytes(),message.length(), mcast, PORT);
        ms.send(dp);
    }

    @Override
    public void close() throws IOException {
        ms.close();
    }
}

// l'id du robot sera un nombre généré entre 1 à 1000 par exemple

// la deuxieme solution etant dire que tout le monde est robot 1 et si ya un deuxieme robot 1 alors il est robot 2
// et si ya deux robots 2 alors il est robot 3 et ainsi de suite via des sockets multicast