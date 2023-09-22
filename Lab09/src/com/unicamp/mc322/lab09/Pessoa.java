package com.unicamp.mc322.lab09;

public class Pessoa {
	
	private String nome;
	private int idade;
	private String cpf;
	private boolean prioridade;
	
	public Pessoa(String umNome, int umaIdade, String documento, boolean aPrioridade) {
		nome = umNome;
		idade = umaIdade;
		cpf = documento;
		prioridade = aPrioridade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean getPrioridade() {
		return this.prioridade;
	}
}
