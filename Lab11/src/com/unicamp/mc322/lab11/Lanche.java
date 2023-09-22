package com.unicamp.mc322.lab11;

public class Lanche {
	
	private String identificador;
	private String nome;
	private double preco;
	private double precoSemDesconto;
	
	public Lanche (String sigla, String name, double price) {
		identificador = sigla;
		nome = name;
		preco = price;
		precoSemDesconto = price;
	}
	
	public void obterDesconto(double desconto, TipoDesconto tipoDesconto) {
		switch (tipoDesconto) {
		case PORCENTAGEM:
			this.preco = this.preco * (1 - (desconto/100));
			break;
		case FIXO:
			this.preco = this.preco - desconto;
			break;
		}
	}
	
	public void retirarDesconto() {
		this.preco = this.precoSemDesconto;
	}
	
	public boolean ehPrecoSemDesconto() {
		if (this.preco == this.precoSemDesconto) {
			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirLanche() {
		System.out.print("[" + this.identificador + "]" + " " + this.nome + " R$ " + this.preco);
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public double getPrecoSemDesconto() {
		return this.precoSemDesconto;
	}
}
