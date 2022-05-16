/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.your.knowladge;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class clientFasade {
    clientConnection client;
    public clientFasade(Socket s){
    client=new clientConnection(s);
    Scanner read=new Scanner(System.in);
    }
    public void run() throws IOException {  
        System.out.println("\tAre you ready to test your knowladge!!\n-------------------- Let's start --------------------");       
        client.connected();
        QandA game=new clientQandA(client);
        game.play();
    }

}
