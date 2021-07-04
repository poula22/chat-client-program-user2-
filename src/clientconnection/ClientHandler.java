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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author george
 */
public class ClientHandler implements Runnable{
    private Socket client;
    private JTextField jTextField1;
    private JTextArea jTextArea1;
    private ServerSocket server;
    private boolean write=false;
    private OutputStream o;
    private PrintStream clientOutput;
    public ClientHandler(Socket client,JTextField jTextField1,JTextArea jTextArea1){
        this.client=client;
        this.jTextField1=jTextField1;
        this.jTextArea1=jTextArea1;
        try {
            o=client.getOutputStream();
            clientOutput=new PrintStream(o);
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------------------
    
    public void setWrite(boolean write) {
        this.write = write;
    }
    

    @Override
    public void run() {
        //        InputStream i;
//                OutputStream o;
//                Reader r;
//                BufferedReader clientinput;
//                PrintStream clientOutput;
        String name="poula";
//            Thread t=new Thread();
        
        
        
        try(InputStream i=client.getInputStream();
                Reader r=new InputStreamReader(i);
                BufferedReader serverInput=new BufferedReader(r);
                
                )
        {
//                    String s=jTextField1.getText();
//                    jTextArea1.append("me: "+s+"\n");
//                    clientOutput.println(name+": "+s);
//                
//                
//                    if(s.toLowerCase().trim().contains("bye")){
//                        return;
//                        break;
//                    }
            while(true){
                String clientInputString=serverInput.readLine();
                jTextArea1.append("server: "+clientInputString+"\n");
                jTextField1.setText("");
                if(clientInputString.toLowerCase().contains("bye")){
                    break;
                }
            }
            close();
//                System.out.println("server: "+clientinput.readLine());
//                t.start();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientConnectionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writes(){
        String s=jTextField1.getText();
        jTextArea1.append("me: "+s+"\n");
        clientOutput.println("poula"+": "+s);
        jTextField1.setText("");
    }
    public void close(){
        clientOutput.close();
        try {
            o.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
