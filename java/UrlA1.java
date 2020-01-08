package rmi;
//Programa Java que pida al usuario una URL y utilizando los métodos anteriores
//visualice en pantalla los atributos de dicha URL (protocolo, ordenador, fichero,
//puerto y referencia)

import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;


public class UrlA1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url;

		System.out.println("Introduce una url");
		url = sc.nextLine();

		URL miUrl;
		try {
			miUrl = new URL(url);
			System.out.println("Tiene el protocolo: " + miUrl.getProtocol());
			System.out.println("Nombre del equipo: " + miUrl.getHost());
			System.out.println("El nombre del fichero de la URL: " + miUrl.getFile());
			//https://www.gnu.org:80
			System.out.println("El puerto por defecto del  protocolo asociado con la URL: " + miUrl.getPort());
			//https://www.geeksforgeeks.org#Arnab_Kundu
			System.out.println("Referencia: " + miUrl.getRef());
		} catch (MalformedURLException e) {
			System.err.println("No es una url correcta");
		}
	}

}
