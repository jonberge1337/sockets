package sockets;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.IOException;


public class Conexion {

	public static void main(String[] args) {
		String host;
		int puerto;

		Socket s1 = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la dirección IP o el nombre de dominio del ordenador al que quieres conectarte:");
		host = sc.nextLine();
		
		System.out.println("Introduce el puerto del ordenador al que quieres conectarte:");
		puerto = sc.nextInt();
		
		try {
			s1 = new Socket(host, puerto);
			System.out.println("Conectado a " + s1.getInetAddress().getHostName());
			System.out.println("En el puerto " + s1.getPort());
			System.out.println("Desde el puerto" + s1.getLocalPort());
			System.out.println("En " + s1.getLocalAddress());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No puedo conectarme al puerto 80");
		}

	}

}
