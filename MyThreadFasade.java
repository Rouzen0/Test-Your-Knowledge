package test.your.knowladge;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

// this class will handle every user that will connect to server 
public class MyThreadFasade extends Thread {
    
    private LocalConnect loc;
    private Database db;

    MyThreadFasade(Socket s) {
        loc = new LocalConnect(s);
    }

    public void run() {
        // connect to the database
        db = Database.getInstance();
        Connection  conn=db.getConn();
        //connect user to server and be ready to send or receive message form user or to user
        loc.connected();
        //user send String message to server and server print message
        QandA game=new serverQandA(loc);
        game.play();
    }

}
