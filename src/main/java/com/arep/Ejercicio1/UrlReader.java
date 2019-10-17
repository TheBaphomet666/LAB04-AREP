package com.arep.Ejercicio1;
import java.net.*;

public class UrlReader {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.pepe.com:8080/lola/pedro?lucas=2");
        System.out.println("Protocol: "+url.getProtocol()+"\nAuthority: "+url.getAuthority()+"\nHost: "+url.getHost()
        +"\nPort: "+url.getPort()+"\nPath: "+url.getPath()+"\nQuery: "+url.getQuery()+"\nFile: "+url.getFile()
        +"\nRef: "+url.getRef());
    }
}