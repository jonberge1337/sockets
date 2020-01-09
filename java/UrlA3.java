package rmi;


//Programa que pide al usuario una URL y escribe la información de cabecera de esta
//URL en pantalla (tipo de contenido, codificación, fecha, fecha modificación, 
//fecha expiración y tamaño) Necesitarás crear además de un objeto URL, otro URLConnection

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class UrlA3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url;
		URL miUrl;
		URLConnection conUrl;
		
		System.out.println("Introduce una url:");
		url = sc.nextLine();
		try {
			miUrl = new URL(url);
			conUrl = miUrl.openConnection();

			System.out.println("Tipo de contenido " + conUrl.getContentType());
			System.out.println("Codificación " + conUrl.getContentEncoding());
			System.out.println("Fecha " + new Date(conUrl.getDate()));
			System.out.println("Fecha modificación " + new Date(conUrl.getLastModified()));
			System.out.println("Fecha expiración " + new Date(conUrl.getExpiration()));
			System.out.println("Tamaño " + conUrl.getContentLengthLong());
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
