package test.your.knowladge;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientQandA extends QandA {

    clientConnection client;
    IOdevice device;

    public clientQandA(clientConnection client) {
        this.client = client;
    }

    @Override
    public void questions() {
        device=new IOclient(client);
        device.print();
    }

    @Override
    public void answer() {
        device.read();
    }

    @Override
    public void result() {
        try{
            System.out.print("Nice try your grade is ");       
            System.out.println(client.getMessageFormServer().readLine()+"/15\nThank You For Playing\n-------------------------------------------");
           
        } catch (IOException ex) {
            Logger.getLogger(clientQandA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
