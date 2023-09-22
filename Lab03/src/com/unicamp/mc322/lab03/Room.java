package com.unicamp.mc322.lab03;

public class Room {
	
	private int vip;
	private int ocupacao;
	private int fumante;
	private int arCondicionado;
	private User usuario;
	
	public Room(int premium, int condicao, int fumo, int ar, User user) {
		vip = premium;
		ocupacao = condicao;
		fumante = fumo;
		arCondicionado = ar;
		usuario = user;
	}
	
	public int getOcupacao() {
		return ocupacao;
	}
	
	public void setOcupacao(int ocupation) {
		this.ocupacao = ocupation;
	}
	
	public int getVip() {
		return this.vip;
	}
	
	public void setVip(int i) {
		this.vip = i;
	}
	
	public int getArCondicionado() {
		return this.arCondicionado;
	}
	
	public int getFumante() {
		return this.fumante;
	}
	
	public User getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(User user) {
		this.usuario = user;
	}

}