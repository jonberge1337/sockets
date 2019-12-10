package sockets;

import java.io.*;
import java.net.*;

public class DemoCliente {
    public static void main(String[] args) {     
        try {
            //Creación del objeto cliente para la comunicación con el servidor
            //En este caso tanto la aplicación cliente como la servidora se
            //encuentran en el mismo ordenador (localhost)
            Socket cliente=new Socket("localhost",6000);
            //Creamos el objeto nombre para enviar el nombre al servidor
            ObjectOutputStream nombre= new ObjectOutputStream(cliente.getOutputStream());
            MiObjeto objeto = new MiObjeto("Jon");
            nombre.writeObject(objeto);
            System.out.println("Esperando respuesta...");
            //Creamos el objeto entrada para poder leer el objeto que manda el servidor
            ObjectInputStream entrada=new ObjectInputStream(cliente.getInputStream());
            //Leemos lo que nos ha envíado el servidor
            String resp = (String) entrada.readObject();
            //Lo mostramos en pantalla
            System.out.println("Ha llegado el mensaje del servidor: "+ resp);
            nombre.close();
            entrada.close();
            cliente.close();
            System.out.println("El cliente ha cerrado su conexión");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
