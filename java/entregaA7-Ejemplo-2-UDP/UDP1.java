//Realiza un proyecto utilizando UDP en el que haya una clase Emisor (cliente) que pida al usuario una frase y se la envíe al receptor (servidor). El receptor devolverá al emisor la frase que este le envió pero convertida a mayúsculas.
//El receptor escuchará en el puerto 5000.
//Una vez que todo funciona haz las siguientes modificaciones en el proyecto:
//
//    El receptor puede mostrar la IP del ordenador que le envía la frase y el puerto por el que este escucha.
//    El emisor puede visualizar la IP del ordenador al que ha sido envíada la frase así como el puerto por el que este escucha.
//    Comprueba que ocurre si empiezas ejecutando el emisor y luego el receptor
//    Comprueba que ocurre si ejecutas varias veces el emisor, después de haber ejecutado el receptor
//    Prepara el receptor para que pueda escuchar a varios emisores


/*El emisor envía el nombre María y muestra el mensaje personalizado enviado
desde el receptor*/
package udp;

import java.net.*;
import java.util.Scanner;

public class UDP1 {
    public static void main(String[] args) throws Exception{
    	Scanner sc = new Scanner(System.in);
    	String nombre;
        //Creación del objeto para la comunicación con el servidor
        DatagramSocket socket=new DatagramSocket();

        System.out.println("Introduce una frase que quieras mandar");
        nombre = sc.nextLine();
        //Buffer con el nombre a enviar
        byte[] bEnviar=nombre.getBytes();//el String se convierte en un array de bytes

        InetAddress address=InetAddress.getByName("localhost");
        /*paquete de información a enviar + longitud + destinatario +
        * puerto del destinatario*/
        DatagramPacket packet = new DatagramPacket(bEnviar,bEnviar.length,address,5000);
        //envio el paquete
        socket.send(packet);
        System.out.println("El nombre ha sido enviado al servidor");
        System.out.println("\nEl cliente se prepara para leer la respuesta del servidor");
        //buffer para recibir la respuesta
        byte[] bRecibe=new byte[256];
        //Creación del paquete para recibir el saludo del servidor
        packet=new DatagramPacket(bRecibe,bRecibe.length);
        //Recibe el saludo del servidor
        socket.receive(packet);
        //Muestra el resultado
        String saludo= new String(packet.getData(),0,packet.getLength());
        System.out.println(saludo);
        System.out.println("Receptor ip " + packet.getAddress() + " puerto" +
                            packet.getPort());

        socket.close();
    }
}
