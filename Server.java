
package test.your.knowladge;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        //server will wait until ckient get connected and server can handle multiple clients
        ServerSocket serv = new ServerSocket(1900);
        while (true) {
            Socket soc = serv.accept();
            MyThreadFasade thread = new MyThreadFasade(soc);
            thread.start();
        }
    }
}
