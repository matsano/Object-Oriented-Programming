package com.unicamp.mc322.lab08;

import java.time.*;

public class Seguidor {
	
	private Usuario usuarioSeguidor;
	private LocalDateTime dataComecouSeguir;
	
	public Seguidor(Usuario usuario) {
		usuarioSeguidor = usuario;
		dataComecouSeguir = LocalDateTime.now();
	}
	
	public void imprimirSeguidor() {
		System.out.print("	- " + this.usuarioSeguidor.getApelido());
		System.out.println(" (Comecou seguindo em: " + this.dataComecouSeguir.getDayOfMonth() + "/" + this.dataComecouSeguir.getMonthValue() + "/" + this.dataComecouSeguir.getYear() + ")");
	}
}
