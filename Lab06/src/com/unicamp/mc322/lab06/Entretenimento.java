package com.unicamp.mc322.lab06;

public abstract class Entretenimento {
	
	private String nome;
	protected String autor;
	protected int duracao;
	protected double armazenamento;
	
	public Entretenimento(String theName) {
		nome = theName;
	}
	
	public Entretenimento(String theName, String theArtist, int time) {
		nome = theName;
		autor = theArtist;
		duracao = time;
	}
	
	public abstract double calcularArmazenamento();
	
	protected Entretenimento obterDuracaoMaior(Entretenimento e1) {
		if (this.duracao > e1.duracao) {
			return this;
		} else {
			return e1;
		}
	}
	
	protected Entretenimento obterDuracaoMenor(Entretenimento e1) {
		if (this.duracao < e1.duracao) {
			return this;
		} else {
			return e1;
		}
	}
	
	protected int getDuracao() {
		return this.duracao;
	}
	
	protected String getNome() {
		return this.nome;
	}
	
	protected String getAutor() {
		return this.autor;
	}
	
	protected double getArmazenamento() {
		return this.armazenamento;
	}
	
}