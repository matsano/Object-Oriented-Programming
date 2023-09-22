package com.unicamp.mc322.lab13;

import java.time.*;
import java.util.regex.Pattern;

public class Pessoa {
	
	private int idade;
	private String cpf;
	private String nome;
	
	public Pessoa(LocalDate dataNascimento, String documento, String umNome) throws CpfInvalidoException {
		idade = Period.between(dataNascimento, LocalDate.now()).getYears();
		nome = umNome;
		cpf = documento;
		if (this.cpfEhValido() == false) {
			throw new CpfInvalidoException("Cpf do(a) " + this.nome + " esta incorreto");
		}
	}
	
	private boolean cpfEhValido() {
		boolean matchFound = Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\/\\d{2}", cpf);
		if (matchFound) {
			return true;
		}
		return false;
	}
	
	public void imprimirInformacaoReduzida() {
		System.out.println("Nome: " + this.nome);
	}
	
	public void imprimirInformacaoCompleta() {
		this.imprimirInformacaoReduzida();
		System.out.println("CPF: " + this.cpf);
		System.out.println("Idade: " + this.idade);
	}
	
	public int getIdade() {
		return this.idade;
	}
	
}
