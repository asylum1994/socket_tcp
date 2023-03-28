/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ServerSocket servidor = null;
            Socket sc = null;
            int puerto = 5000; 
            DataInputStream input; 
            DataOutputStream output; 
        try {
            // TODO code application logic here
            servidor = new ServerSocket(puerto);
            System.out.println("servidor iniciado");
            
            while(true){
                sc = servidor.accept(); 
                System.out.println("cliente conectado");
                input = new DataInputStream(sc.getInputStream()); 
                output = new DataOutputStream(sc.getOutputStream()); 
                
                String mensaje = input.readUTF(); 
                System.out.println(mensaje);
                
                output.writeUTF("hola soy el servidor");
                sc.close();
                System.out.println("cliente desconectado");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
