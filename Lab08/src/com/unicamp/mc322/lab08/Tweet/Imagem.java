package com.unicamp.mc322.lab08.Tweet;

import java.time.LocalDateTime;

public class Imagem extends Tweet {
	
	private double resolucao;
	private double tamanhoTotal;
	private String textoParaCego;
	private String extensao;
	
	public Imagem(String umTitulo, LocalDateTime data, double aResolucao, String descricao, String umaExtensao) {
		super(umTitulo, data);
		resolucao = aResolucao;
		tamanhoTotal = aResolucao;
		textoParaCego = descricao;
		extensao = umaExtensao;
		tweetPermitido = verificarPermissao();
	}
	
	
	protected boolean verificarPermissao() {
		if ((this.extensao == "png") || (this.extensao == "jpg") || (this.extensao == "gif")) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void imprimirPublicacao() {
		System.out.print("Imagem: ");
		System.out.println(this.textoParaCego);
	}
}
