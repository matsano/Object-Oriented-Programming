package com.unicamp.mc322.lab08;

import com.unicamp.mc322.lab08.Tweet.*;
import java.time.*;
import java.util.ArrayList;

public class Usuario {
	
	private String nomeCompleto;
	private String email;
	private String senha;
	private String genero;
	private String paisDeOrigem;
	private LocalDateTime dataDeNascimento;
	private String apelido;
	private ArrayList<Seguidor> seguidores;
	private ArrayList<Seguidor> seguindo;
	private ArrayList<Tweet> tweets;
	
	public Usuario(String nome, String enderecoEletronico, String umaSenha, String umGenero, String pais, LocalDateTime nascimento, String umApelido) {
		nomeCompleto = nome;
		email = enderecoEletronico;
		senha = umaSenha;
		genero = umGenero;
		paisDeOrigem = pais;
		dataDeNascimento = nascimento;
		apelido = umApelido;
		seguidores = new ArrayList();
		seguindo = new ArrayList();
		tweets = new ArrayList();
	}
	
	public boolean ehMaiorde18() {
		boolean maiorDeIdade = false;
		LocalDateTime dataHoje = LocalDateTime.now();
		if (dataHoje.getYear() - this.dataDeNascimento.getYear() > 18) {
			maiorDeIdade = true;
		} else if (dataHoje.getYear() - this.dataDeNascimento.getYear() == 18) {
			if (dataHoje.getMonthValue() - this.dataDeNascimento.getMonthValue() > 0) {
				maiorDeIdade = true;
			} else if (dataHoje.getMonthValue() - this.dataDeNascimento.getMonthValue() == 0) {
				if (dataHoje.getDayOfMonth() - this.dataDeNascimento.getDayOfMonth() >= 0) {
					maiorDeIdade = true;
				}
			}
		}
		return maiorDeIdade;
	}
	
	public void seguirUsuario(Usuario usuarioSeguido) {
		Seguidor seguindo = new Seguidor(usuarioSeguido);
		Seguidor seguidor = new Seguidor(this);
		this.seguindo.add(seguindo);
		usuarioSeguido.seguidores.add(seguidor);
	}
	
	public void publicarTweet(Tweet tweet) {
		if (tweet.podePublicarTweet()) {
			this.tweets.add(tweet);
		}
	}
	
	public void gostarTweet(Tweet tweet) {
		tweet.receberLike(this);
	}
	
	public void compartilharTweet(Tweet tweet) {
		tweet.receberRetweet(this);
	}
	
	public void comentarTweet(Tweet tweet, Comentario comentario) {
		if (comentario.getMensagem().length() <= 100) {
			tweet.receberComentario(comentario);
		}
	}
	
	private void imprimirDadosDoUsuario() {
		System.out.println("Nome completo: " + this.nomeCompleto);
		System.out.println("Genero: " + this.genero);
		System.out.println("Pais de origem: " + this.paisDeOrigem);
		System.out.println("Data de nascimento: " + this.dataDeNascimento.getDayOfMonth() + "/" + this.dataDeNascimento.getMonthValue() + "/" + this.dataDeNascimento.getYear());
		System.out.println("Email: " + this.email);
		System.out.println("Apelido: " + this.apelido);
	}
	
	private void imprimirSeguidores() {
		System.out.print("Seguidores: ");
		System.out.println(this.seguidores.size());
		if (this.seguidores != null) {
			for (int numeroSeguidores = 0; numeroSeguidores < this.seguidores.size(); numeroSeguidores++) {
				this.seguidores.get(numeroSeguidores).imprimirSeguidor();
			}
		}
	}
	
	private void imprimirSeguindo() {
		System.out.print("Seguindo: ");
		System.out.println(this.seguindo.size());
		if (this.seguindo != null) {
			for (int numeroSeguindo = 0; numeroSeguindo < this.seguindo.size(); numeroSeguindo++) {
				this.seguindo.get(numeroSeguindo).imprimirSeguidor();
			}
		}
	}
	
	private void imprimirTweets() {
		System.out.print("Tweets: ");
		System.out.println(this.tweets.size());
		if (this.tweets != null) {
			for (int numeroTweet = 0; numeroTweet < this.tweets.size(); numeroTweet++) {
				this.tweets.get(numeroTweet).imprimirTweet();
			}
		}
	}
	
	public void imprimirUsuario() {
		imprimirDadosDoUsuario();
		imprimirSeguidores();
		imprimirSeguindo();
		imprimirTweets();
		System.out.println();
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getApelido() {
		return this.apelido;
	}
}
