/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnection;

import frames.ClientConnectionFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author george
 */
public class ClientConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientConnectionFrame.main(args);
//        try(Socket client =new Socket("127.0.0.1", 7777);
//                InputStream i=client.getInputStream();
//                OutputStream o=client.getOutputStream();
//                Reader r=new InputStreamReader(i);
//                BufferedReader clientinput=new BufferedReader(r);
//                PrintStream clientOutput=new PrintStream(o);
//                Scanner keyboard=new Scanner(System.in);
//                )
//        {
//            String name="poula";
////            Thread t=new Thread();
//            while(true){
//                System.out.print("me: ");
//                String s=keyboard.nextLine();
//                clientOutput.println(name+": "+s);
//                if(s.toLowerCase().trim().contains("bye")){
//                                break;
//                            }
//                System.out.println("server: "+clientinput.readLine());
////                t.start();
//                
//            }
//            
//        } catch (IOException ex) {
//            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
