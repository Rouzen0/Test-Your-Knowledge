package test.your.knowladge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LocalConnect implements connection {

    private Scanner select = new Scanner(System.in);
    private InputStreamReader reader ;
    private BufferedReader read;
    private PrintWriter out;
    private BufferedWriter writer;
    private Socket soc;

    public LocalConnect(Socket s) {
        soc = s;
    }

    @Override
    public void connected() {
        try{
        System.out.println("Client " + soc.getRemoteSocketAddress() + " connected to server...");
        reader = new InputStreamReader(soc.getInputStream());
        read = new BufferedReader(reader);
        out = new PrintWriter(soc.getOutputStream(), true);
        writer = new BufferedWriter(out);
        }
        catch (Exception ex) {
            
        }
    }

    public Scanner getSelect() {
        return select;
    }

    public InputStreamReader getReader() {
        return reader;
    }

    public BufferedReader getRead() {
        return read;
    }

    public PrintWriter getOut() {
        return out;
    }

   
}
