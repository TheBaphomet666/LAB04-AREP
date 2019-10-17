package com.arep.Ejercicio6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

    private DatagramSocket socket;
    private String date;

    public static void main(String[] args) throws SocketException {
        Client datagram= new Client();
        datagram.run();

    }
    public Client() throws SocketException{
        socket = new DatagramSocket();
        socket.setSoTimeout(6000);
    }

    @Override
    public void run() {
        while(true) {
            try {
                byte[] buf = new byte[256];
                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9999);
                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                date= received;
                System.out.println("Date: " + received);
            } catch (SocketTimeoutException ex) {
                System.out.println("Unable to get Date, last date was "+date);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}