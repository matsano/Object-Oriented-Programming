package com.unicamp.mc322.lab08.Tweet;

import java.time.LocalDateTime;

public class Video extends Tweet {
	
	private double duracao;
	private double tamanhoTotal;
	private String extensao;
	
	public Video(String umTitulo, LocalDateTime data, double tempo, String umaExtensao) {
		super(umTitulo, data);
		duracao = tempo;
		tamanhoTotal = tempo*3;
		extensao = umaExtensao;
		tweetPermitido = verificarPermissao();
	}
	
	protected boolean verificarPermissao() {
		if ((this.extensao == "avi") || (this.extensao == "wmv") || (this.extensao == "flv")) {
			return true;
		} else {
			return false;
		}		
	}
	
	protected void imprimirPublicacao() {
		System.out.println("Video (duracao: " + this.duracao + " minutos)");
	}
}
