package com.unicamp.mc322.lab03;

public class User {
	
	private String nome;
	private String cpf;
	private String nascimento;
	private String genero;
	private double saldoAtual;
	private int fumante;
	
	public User(String name, String documento, String data, String gen, double sal, int fumo) {
		nome = name;
		cpf = documento;
		nascimento = data;
		genero = gen;
		saldoAtual = sal;
		fumante = fumo;
	}
	
	public double getSaldoAtual() {
		return this.saldoAtual;
	}
	
	public void setSaldoAtual(double novoSaldo) {
		this.saldoAtual = novoSaldo;
	}
	
	public int getFumante() {
		return this.fumante;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void obterInformacoes() {
		System.out.println("Nome = " + this.nome);
		System.out.println("CPF = " + this.cpf);
		System.out.println("Data de nascimento = " + this.nascimento);
		System.out.println("Genero = " + this.genero);
		if (this.fumante == 1) {
			System.out.println("Fumante");
		} else {
			System.out.println("Nao fumante");
		}
	}

}