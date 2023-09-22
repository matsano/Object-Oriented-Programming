package com.unicamp.mc322.lab08.Tweet;

import java.time.*;
import com.unicamp.mc322.lab08.Usuario;

public class Comentario {
	
	private Usuario comentarista;
	private String mensagem;
	private LocalDateTime dataDoComentario;
	
	public Comentario(Usuario usuario, String umaMensagem) {
		comentarista = usuario;
		mensagem = umaMensagem;
		dataDoComentario = LocalDateTime.now();
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public void imprimirComentario() {
		System.out.println("	" + this.comentarista.getApelido() + ": " + this.mensagem + " (" + this.dataDoComentario.getDayOfMonth() + "/" + this.dataDoComentario.getMonthValue() + "/" + this.dataDoComentario.getYear() + ")");
	}
	
}
