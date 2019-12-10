package sockets;

import java.io.*;
import java.net.*;

public class MoldeServidor extends Thread{
	private Socket clientenuevo;

	public MoldeServidor(Socket sc) {
		this.clientenuevo = sc;
	}
	
	public void run() {

		//Visualizamos la dirección IP de la máquina a la que nos hemos conectado
		System.out.println("Se conectaron desde la IP: "+clientenuevo.getInetAddress().getHostAddress());
		try {
			//Creamos el objeto entrada para poder leer objetos a través de la red
			ObjectInputStream entrada;
			entrada = new ObjectInputStream(clientenuevo.getInputStream());
			System.out.println("Ha llegado el mensaje del cliente al servidor");
			//leemos lo que el cliente nos ha envíado
			MiObjeto nom = (MiObjeto) entrada.readObject();
			//Mostramos en pantalla lo leído
			System.out.println("Nombre: " + nom);
			System.out.println("Preparando respuesta...");
			//Creamos el objeto resp para poder escribir objetos en la red
			ObjectOutputStream resp = new ObjectOutputStream(clientenuevo.getOutputStream());
			String saludo ="Hola "+ nom+ ", la hora en milisegundos del sistema es "+ System.currentTimeMillis();
			//escribimos la respuesta para el cliente
			resp.writeObject(saludo);
			System.out.println("Saludo enviado...");
			clientenuevo.close();
			entrada.close();
			resp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
