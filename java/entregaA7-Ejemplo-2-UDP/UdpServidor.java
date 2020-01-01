//Realiza un proyecto utilizando UDP en el que haya una clase Emisor (cliente) que pida al usuario una frase y se la envíe al receptor (servidor). El receptor devolverá al emisor la frase que este le envió pero convertida a mayúsculas.
//El receptor escuchará en el puerto 5000.
//Una vez que todo funciona haz las siguientes modificaciones en el proyecto:
//
//    El receptor puede mostrar la IP del ordenador que le envía la frase y el puerto por el que este escucha.
//    El emisor puede visualizar la IP del ordenador al que ha sido envíada la frase así como el puerto por el que este escucha.
//    Comprueba que ocurre si empiezas ejecutando el emisor y luego el receptor
//    Comprueba que ocurre si ejecutas varias veces el emisor, después de haber ejecutado el receptor
//    Prepara el receptor para que pueda escuchar a varios emisores


/*El receptor recibe el nombre del cliente, crea un saludo personalizado y lo
* envía al cliente */
package udp;

import java.net.*;

public class UdpServidor {
	public static void main(String[] args) throws Exception{
		//Creación del socket para la comunicación con el cliente
		//El servidor escucha por el puerto 6000
		DatagramSocket socket=new DatagramSocket(5000);

		System.out.println("Esperando a la conexion... ");
		//buffer para recibir el nombre del cliente
		byte[] buffer=new byte[100];

		//Creación del paquete para recibir información
		DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
		while (true) {

			//recibe el nombre que le envia el cliente
			socket.receive(packet);
			System.out.println("Emisor dirección ip " + packet.getAddress()
			+ " puerto " + packet.getPort());

			System.out.println("Paquete recibido");


			//Se construye el String a enviar para enviar el saludo
			String cadena= new String(packet.getData(),0,packet.getLength());
			String saludo= cadena.toUpperCase();
			//buffer para enviar el saludo
			buffer=saludo.getBytes();

			//obtenemos la dirección IP del cliente
			InetAddress address = packet.getAddress();
			//se construye el paquete a envíar
			/*información a enviar + longitud  + destinatario +
			 * puerto del destinatario*/
			packet= new DatagramPacket(buffer,buffer.length,address,packet.getPort());
			//Envia el saludo al cliente
			socket.send(packet);
			System.out.println("Respuesta enviado ");
		}
//		socket.close();
	}

}
