package com.unicamp.mc322.lab10.Usuario;

public class Cliente extends Usuario {
	
	private double coordenadaX;
	private double coordenadaY;
	private int numeroCompras;
	
	public Cliente(String oNome, String documento, double x, double y) {
		super(oNome, documento);
		coordenadaX = x;
		coordenadaY = y;
		numeroCompras = 0;
	}
	
	public void aumentarNumeroCompras() {
		this.numeroCompras ++;
	}
	
	public void diminuirNumeroCompras() {
		this.numeroCompras --;
	}
	
	public boolean ehPrimeiroPedido() {
		return this.numeroCompras == 0;
	}
	
	public void imprimirCliente() {
		System.out.println("- Cliente: " + this.nome + "(CPF: " + this.cpf + ")");
	}
	
	public double getCoordenadaX() {
		return this.coordenadaX;
	}
	
	public double getCoordenadaY() {
		return this.coordenadaY;
	}
}
