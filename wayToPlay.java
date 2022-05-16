/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.your.knowladge;

import java.util.Scanner;


public class wayToPlay {
    Scanner read=new Scanner(System.in);

    public String wayToConnect() {
        System.out.print("Enter 1 if your playing locally. 2 if you're playing with your friends ");
        int choice= read.nextInt(); 
        String s="";
        while(choice!=1 && choice!=2){
            System.err.println("plase enter 1 or 2 only");
             choice= read.nextInt(); 
        }
        if(choice==1){
        s="localhost";
        }
        if(choice==2){
            System.out.println("plase write server ip with dots");
            s=read.nextLine();
            s=read.nextLine();
        }  
        return s;
    }
    
    
}
