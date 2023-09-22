package com.unicamp.mc322.lab08.Tweet;

import java.time.LocalDateTime;

public class Texto extends Tweet {
	
	private String texto;
	private String idioma;
	
	public Texto(String umTitulo, LocalDateTime data, String textoDigitado, String lingua) {
		super(umTitulo, data);
		texto = textoDigitado;
		idioma = lingua;
		tweetPermitido = verificarPermissao();
	}
	
	protected boolean verificarPermissao() {
		String[] palavras = this.texto.split(" ");
		if (palavras.length <= 1200) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void imprimirPublicacao() {
		System.out.println("Texto (em " + this.idioma + "):");
		System.out.println(this.texto);
	}
}
