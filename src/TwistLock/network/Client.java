package TwistLock.network;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Closeable{

    private final int PORT = 8000;

    DatagramSocket ds;

    public Client() {
        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    //attention c'est bloquant
    public String getMessage () throws IOException {
        DatagramPacket msg = new DatagramPacket(new byte[2048], 2048);
        ds.receive(msg);
        return new String(msg.getData()).trim();
    }

    public void sendMessage (String message) {
        try {
            DatagramPacket envoi = new DatagramPacket(message.getBytes(), message.length(),InetAddress.getByName("127.0.0.1"),8000);
            ds.send(envoi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        ds.close();
    }

    public static void main(String[] args) {
        String reception = "";
        try (Client c = new Client()) {
            c.sendMessage("test");
            System.out.println(c.getMessage());
            System.out.println(c.getMessage());
            System.out.println(c.getMessage());
            while (!reception.contains("Partie Terminée")) {
                reception = c.getMessage();
                System.out.println(reception);
                if(reception.contains("A vous de jouer")) {
                    c.sendMessage(new Scanner(System.in).nextLine());
                }
            }
        } catch (Exception e) {}
    }
}