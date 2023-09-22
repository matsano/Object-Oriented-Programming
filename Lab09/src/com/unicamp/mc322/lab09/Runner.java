package com.unicamp.mc322.lab09;

public class Runner {
	
	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa("Matheus", 20, "303.030.030-00", false);
		Pessoa pessoa2 = new Pessoa("Guilherme", 70, "111.222.333-44", true);
		Pessoa pessoa3 = new Pessoa("Gustavo", 40, "555.444.333-22", false);
		Pessoa pessoa4 = new Pessoa("Enzo", 2, "111.222.333-44", true);
		Pessoa pessoa5 = new Pessoa("Maria", 30, "232.343.454-56", true);
		Pessoa pessoa6 = new Pessoa("Larissa", 45, "989.789.356-74", false);
		Pessoa pessoa7 = new Pessoa("Rodrigo", 23, "345.987.593-01", false);
		
		FilaDePrioridadeComposicao composicao =  new FilaDePrioridadeComposicao();
		FilaDePrioridadeHeranca heranca = new FilaDePrioridadeHeranca();
		
		composicao.adicionar(pessoa1);
		composicao.adicionar(pessoa3);
		composicao.adicionar(pessoa6);
		composicao.adicionar(pessoa7);
		composicao.adicionarPrioritario(pessoa2);
		composicao.adicionarPrioritario(pessoa4);
		composicao.adicionarPrioritario(pessoa5);
		composicao.imprimir();
		
		heranca.adicionar(pessoa1);
		heranca.adicionar(pessoa3);
		heranca.adicionar(pessoa6);
		heranca.adicionar(pessoa7);
		heranca.adicionarPrioritario(pessoa2);
		heranca.adicionarPrioritario(pessoa4);
		heranca.adicionarPrioritario(pessoa5);
		heranca.imprimir();
		
	}
}
