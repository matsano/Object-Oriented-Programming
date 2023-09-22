package com.unicamp.mc322.lab08.Tweet;

import java.time.*;
import com.unicamp.mc322.lab08.Usuario;

public class Retweet {
	
	private Usuario quemCompartilhou;
	private LocalDateTime dataDoRetweet;
	
	public Retweet(Usuario usuario) {
		quemCompartilhou = usuario;
		dataDoRetweet = LocalDateTime.now();
	}
	
	public void imprimirRetweet() {
		System.out.println("	" + this.quemCompartilhou.getApelido() + " (" + this.dataDoRetweet.getDayOfMonth() + "/" + this.dataDoRetweet.getMonthValue() + "/" + this.dataDoRetweet.getYear() + ")");
	}
}
