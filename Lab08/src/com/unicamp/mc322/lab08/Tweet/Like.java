package com.unicamp.mc322.lab08.Tweet;

import java.time.*;
import com.unicamp.mc322.lab08.Usuario;

public class Like {
	
	private Usuario quemCurtiu;
	private LocalDateTime dataDoLike;
	
	public Like(Usuario usuario) {
		quemCurtiu = usuario;
		dataDoLike = LocalDateTime.now();
	}
	
	public void imprimirLike() {
		System.out.println("	" + this.quemCurtiu.getApelido() + " (" + this.dataDoLike.getDayOfMonth() + "/" + this.dataDoLike.getMonthValue() + "/" + this.dataDoLike.getYear() + ")");
	}
}
