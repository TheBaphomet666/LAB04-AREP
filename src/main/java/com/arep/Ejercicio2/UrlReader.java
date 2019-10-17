package com.arep.Ejercicio2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import java.util.ArrayList;

public class UrlReader {

    public static void main(String[] args) {
        Boolean run=true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write the URL to examine please:");
            try {
                String input = scanner.next();
                if(input.equals("exit")){
                    System.exit(1);
                }
                URL url = new URL(input);
                try {
                    File f = new File("src/main/resources/resultado.html");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String inputLine = null;
                    ArrayList<String> lines = new ArrayList<>();
                    while ((inputLine = bufferedReader.readLine()) != null) {
                        lines.add(inputLine);
                    }
                    FileUtils.writeLines(f, lines);
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("There was an exception processing your request: " + e.getMessage());
                }
            } catch (MalformedURLException e) {
                System.err.println("The given URL is not valid or has a problem");
            }
        }
    }
}