package com.unicamp.mc322.lab08.Tweet;

import java.time.LocalDateTime;

public class Website extends Tweet {
	
	private LocalDateTime dataDeVisita;
	
	public Website(String umTitulo, LocalDateTime dataPublicado, LocalDateTime dataVisitada) {
		super(umTitulo, dataPublicado);
		dataDeVisita = dataVisitada;
		tweetPermitido = verificarPermissao();
	}
	
	protected boolean verificarPermissao() {
		return true;
	}
	
	protected void imprimirPublicacao() {
		System.out.println("Website");
		System.out.println("Ultima visita: " + this.dataDeVisita);
	}
}
