package com.arep.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
                }
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
                }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    clientSocket.getInputStream()));
            String inputLine, outputLine;
            String op= "cos";
            ArrayList<String> operations = new ArrayList<> (Arrays.asList("cos", "sin", "tan"));
            while ((inputLine = in.readLine()) != null) {

                String [] input = inputLine.split(":");
                //System.out.println(input[0]);
                if(input.length==2 && operations.contains(input[1]) && input[0].equals("fun")){
                    op = input[1];
                    out.println("Changed operation to: "+op);
                }
                else if(input.length==1){
                    Double val = Double.parseDouble(input[0]);
                    Double response=null;
                    if(op.equals("cos")){
                        response= Math.cos(val);
                    }
                    else if(op.equals("sin")){
                        response= Math.sin(val);
                    }
                    else if(op.equals("tan")){
                        response= Math.tan(val);
                    }
                    out.println("Result "+op+": "+response);
                }
                else{
                    out.println("Not supported Operation");
                }

                }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
}
