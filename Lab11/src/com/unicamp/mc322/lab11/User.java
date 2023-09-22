package com.unicamp.mc322.lab11;

public class User {
	
	private String nome;
	private String Cpf;
	private double coordenadaX;
	private double coordenadaY;
	private int numeroCompras;
	
	public User (String name, String documento, int coordX, int coordY) {
		nome = name;
		Cpf = documento;
		coordenadaX = coordX;
		coordenadaY = coordY;
		numeroCompras = 0;
	}
	
	public void aumentarNumeroCompras() {
		this.numeroCompras ++;
	}
	
	public void diminuirNumeroCompras() {
		this.numeroCompras --;
	}
	
	public void imprimirUsuario() {
		System.out.println("Usuario: " + this.nome + " (" + this.Cpf + ")");
	}
	
	public boolean ehPrimeiroPedido() {
		return this.numeroCompras == 0;
	}
	
	public boolean fezDezPedidos() {
		return (this.numeroCompras + 1) % 10 == 0;
	}
}
