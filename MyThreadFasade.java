package test.your.knowladge;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// this class will handle every user that will connect to server 
public class MyThreadFasade extends Thread {

    private Socket soc;
    private LocalConnect loc;
    private Database db;

    MyThreadFasade(Socket s) {
        loc = new LocalConnect(s);
    }

    public void run() {
        try {
            // connect to the database 
            db = Database.getInstance();
            //connect user to server and be ready to send or receive message form user or to user
            loc.connected();
            //server send message to user 
            loc.getOut().print("hello user");
            //user send String message to server and server print message
            System.out.println(loc.getRead().readLine());
            //useer send String their choise A,B,C or D
            int choise = loc.getRead().read();

        } catch (IOException ex) {
            Logger.getLogger(MyThreadFasade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
