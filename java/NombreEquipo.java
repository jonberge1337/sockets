import java.net.*;
import java.util.Scanner;

public class NombreEquipo{
    public static void main(String[] args) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        InetAddress host = null;
        do {
            System.out.println("Introduce el nombre del equipo");
            nombre = sc.nextLine();
            try {
                host = InetAddress.getByName(nombre);
                System.out.println("La ip de este equipo es " + host.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println("No hay ningun equipo con ese nombre");
            }
            // si imprimes el host te aparece primero nombre del host/ip
            System.out.println(host);
            host = null;
            System.out.println("Desea volver a repetir?");
        } while (sc.nextLine().equalsIgnoreCase("SI"));
        sc.close();
    }
}
