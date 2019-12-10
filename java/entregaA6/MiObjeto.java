package sockets;

import java.io.Serializable;

public class MiObjeto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mensaje;

	public MiObjeto(String mensaje) {
		this.setMensaje(mensaje);
	}

	public String toString() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}


