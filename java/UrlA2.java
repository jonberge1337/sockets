package rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

//Realiza un programa que pida una URL al usuario y escriba en pantalla el contenido
//de dicha URL. Necesitarás utilizar el método openStream() para crear un objeto 
//InputStream con el que poder leer el contenido de la URL

public class UrlA2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url;
		URL miUrl;
		String linea;

		System.out.println("Introduce una URL:");
		url = sc.nextLine();
		try {
			miUrl = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(miUrl.openStream()));
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.err.println("No se pudo leer la url");
		}

	}

}
