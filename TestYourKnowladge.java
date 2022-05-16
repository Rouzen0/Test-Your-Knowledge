package test.your.knowladge;

import java.net.Socket;
import java.util.Scanner;

public class TestYourKnowladge {

    public static void main(String[] args) {
        wayToPlay play = new wayToPlay();
        String s=play.wayToConnect();
        try {
            Socket socket = new Socket(s, 1900);
            clientFasade client = new clientFasade(socket);
            client.run();

        } catch (Exception ex) {
            System.err.println("somting went wrong");
        }

    }
}
