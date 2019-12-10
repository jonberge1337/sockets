package sockets;

import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
    public static void main(String[] args) {
        try{
            //Se crea el objeto servidor para escuchar las peticiones por el puerto 6000
            ServerSocket servidor=new ServerSocket(6000);
            //Se crea el objeto clientenuevo para realizar la comunicación individualizada
            //con cada cliente
            System.out.println("El server se queda en espera a que le llegue alguna petición de algún cliente...");
            while (true) {
            	Socket clientenuevo=servidor.accept();
            	MoldeServidor hilo = new MoldeServidor(clientenuevo);
            	hilo.start();
            }
//            servidor.close();
//            System.out.println("El servidor ha cerrado la conexión");
        } catch (Exception ex) {
        	System.out.println("Error: "+ex.getMessage());
        }
    }

}