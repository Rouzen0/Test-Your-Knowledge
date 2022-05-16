/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.your.knowladge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientConnection implements connection {

    private InputStreamReader reader;
    private BufferedReader messageFormServer;
    private PrintWriter out;
    private Socket soc;

    public clientConnection(Socket s) {
        soc = s;
    }

    @Override
    public void connected() {
        try {
            reader = new InputStreamReader(soc.getInputStream());
            messageFormServer = new BufferedReader(reader);
            out = new PrintWriter(soc.getOutputStream(), true);
        } catch (Exception ex) {
            System.err.println("somting went wrong with your connection");
        }
    }

    public BufferedReader getMessageFormServer() {
        return messageFormServer;
    }

    public PrintWriter sendToServer() {
        return out;
    }
}
