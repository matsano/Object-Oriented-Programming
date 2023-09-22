package com.unicamp.mc322.lab08.Tweet;

import java.time.*;
import java.util.ArrayList;
import com.unicamp.mc322.lab08.Usuario;

public abstract class Tweet {
	
	private String titulo;
	private LocalDateTime dataDePublicacao;
	protected boolean tweetPermitido;
	protected ArrayList<Like> likes;
	protected ArrayList<Retweet> retweets;
	protected ArrayList<Comentario> comentarios;
		
	protected Tweet(String umTitulo, LocalDateTime data) {
		titulo = umTitulo;
		dataDePublicacao = data;
		tweetPermitido = verificarTituloPermitido();
		likes = new ArrayList();
		retweets = new ArrayList();
		comentarios = new ArrayList();
	}
	
	private boolean verificarTituloPermitido() {
		if (this.titulo.length() <= 60) {
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract boolean verificarPermissao();
	
	protected abstract void imprimirPublicacao();
	
	public boolean podePublicarTweet() {
		return this.tweetPermitido;
	}
	
	public void receberLike(Usuario seguidor) {
		Like like = new Like(seguidor);
		this.likes.add(like);
	}
	
	public void receberRetweet(Usuario seguidor) {
		Retweet retweet = new Retweet(seguidor);
		this.retweets.add(retweet);
	}
	
	public void receberComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	private void imprimirLikes() {
		System.out.print("	- Likes:");
		System.out.println(this.likes.size());
		if (this.likes != null) {
			for (int numeroLikes = 0; numeroLikes < this.likes.size(); numeroLikes++) {
				this.likes.get(numeroLikes).imprimirLike();
			}
		}
	}
	
	private void imprimirRetweets() {
		System.out.print("	- Retweets:");
		System.out.println(this.retweets.size());
		if (this.retweets != null) {
			for (int numeroRetweets = 0; numeroRetweets < this.retweets.size(); numeroRetweets++) {
				this.retweets.get(numeroRetweets).imprimirRetweet();
			}
		}
	}
	
	private void imprimirComentarios() {
		System.out.print("	- Comentarios:");
		System.out.println(this.comentarios.size());
		if (this.retweets != null) {
			for (int numeroComentarios = 0; numeroComentarios < this.comentarios.size(); numeroComentarios++) {
				this.comentarios.get(numeroComentarios).imprimirComentario();
			}
		}
	}
	
	public void imprimirTweet() {
		System.out.println(this.titulo);
		System.out.println("Publicado em: " + this.dataDePublicacao.getDayOfMonth() + "/" + this.dataDePublicacao.getMonthValue() + "/" + this.dataDePublicacao.getYear());
		System.out.println();
		imprimirPublicacao();
		imprimirLikes();
		imprimirRetweets();
		imprimirComentarios();
	}	
	
}
