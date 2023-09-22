package com.unicamp.mc322.lab08;

import com.unicamp.mc322.lab08.Tweet.*;
import java.time.LocalDateTime;

public class Runner {
	
	public static void main(String[] args) {
		
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime nascimentoUsuario1 = LocalDateTime.of(1986, 5, 2, 0, 0);
		LocalDateTime nascimentoUsuario2 = LocalDateTime.of(1975, 4, 6, 0, 0);
		LocalDateTime nascimentoUsuario3 = LocalDateTime.of(2001, 12, 21, 0, 0);
		
		Usuario usuario1 = new Usuario("Joao Costa", "jogaoc@gmail.com", "jo@o12345", "masculino", "Brasil", nascimentoUsuario1, "joaoc");
		Usuario usuario2 = new Usuario("Maria Silva", "msilva@outlook.com", "m@ria@", "feminino", "Argentina", nascimentoUsuario2, "msilva");
		Usuario usuario3 = new Usuario("Carlos Vargas", "carlos.vargas@gmail.com", "carlos123", "masculino", "Brasil", nascimentoUsuario3, "varguinhas");
		
		Twittery twittery = new Twittery();
		twittery.cadastrarUsuario(usuario1);
		twittery.cadastrarUsuario(usuario2);
		twittery.cadastrarUsuario(usuario3);
		
		Video video1 = new Video("Primeiro dia na Praia", hoje, 20, "avi");
		usuario1.publicarTweet(video1);
		
		Imagem imagem1 = new Imagem("Cachorro Dormindo", hoje, 1080, "cachorro dormindo na varanda", "gif");
		usuario3.publicarTweet(imagem1);
		
		usuario1.seguirUsuario(usuario2);
		usuario1.seguirUsuario(usuario3);
		usuario3.seguirUsuario(usuario1);
		usuario2.seguirUsuario(usuario1);
		usuario2.seguirUsuario(usuario3);
		
		usuario3.gostarTweet(video1);
		
		Comentario comentarioDeCarlos = new Comentario(usuario3, "Parabens pelo passeio.");
		usuario3.comentarTweet(video1, comentarioDeCarlos);
		
		usuario2.gostarTweet(imagem1);
		usuario1.gostarTweet(imagem1);
		usuario1.compartilharTweet(imagem1);
		Comentario comentarioDeMaria = new Comentario(usuario2, "Como cresceu seu cachorro.");
		usuario2.comentarTweet(imagem1, comentarioDeMaria);
		
		usuario1.imprimirUsuario();
		usuario2.imprimirUsuario();
		usuario3.imprimirUsuario();
	}
}
