
package test.your.knowladge;

import java.io.IOException;
import java.util.Scanner;


public class IOclient implements IOdevice{
    clientConnection client;
    Scanner read= new Scanner(System.in);
    public IOclient(clientConnection client){
    this.client=client;
    }

    @Override
    public void print() {
        try {
            System.out.println(client.getMessageFormServer().readLine());
            System.out.println(client.getMessageFormServer().readLine());
            System.out.println(client.getMessageFormServer().readLine());
            System.out.println(client.getMessageFormServer().readLine());
            System.out.println(client.getMessageFormServer().readLine());
            System.out.print(client.getMessageFormServer().readLine());
        } catch (IOException ex) {
            System.err.println("somting went wrong");
        }
        
    }

    @Override
    public String read() {
        try {
            String answer = read.nextLine().toLowerCase();
            while(!answer.equals("a")&&!answer.equals("b")&&!answer.equals("c")&&!answer.equals("d")){
            System.err.println("please enter a,b,c or d");
            answer = read.nextLine().toLowerCase();
        }
            client.sendToServer().println(answer);
            client.sendToServer().flush();
            System.out.println(client.getMessageFormServer().readLine());
        } catch (IOException ex) {
            System.err.println("somting went wrong");
        }
        
        return "";
    }
    
}
