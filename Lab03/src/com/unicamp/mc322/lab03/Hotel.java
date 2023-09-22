package com.unicamp.mc322.lab03;

public class Hotel {
	
	private String nome;
	private String endereco;
	private String telefone;
	private double precoNormal;
	private double precoVip;
	private int quantidadeQuartos;
	private Room quartos[];
	
	
	public Hotel (String name, String end, String tel, double normal, double vip, int quantidade) {
		nome = name;
		endereco = end;
		telefone = tel;
		precoNormal = normal;
		precoVip = vip;
		quantidadeQuartos = quantidade;
		quartos = new Room[quantidade];
	}
	
	public void adicionarQuarto(Room quarto) {
		int i = 0;
		if (quarto.getVip() == 0) {
			i = 10;
			while ((quartos[i] != null) && (i < this.getQuantidadeQuartos())) {
				i++;
			}
			if (i >= this.getQuantidadeQuartos()) {
				System.out.println("Nao ha quartos comuns disponiveis");
			} else {
				quartos[i] = quarto;
			}
		} else {
			while (this.quartos[i] != null) {
				i++;
			}
			if (i < 10) {
				this.quartos[i] = quarto;
			} else {
				System.out.println("Nao ha quartos vip disponiveis");
			}
		}
	}
	
	public void obterDisponivel() {
		int i = 0;
		System.out.print("Quartos disponiveis:");
		while (i < quartos.length) {
			if (quartos[i] != null) {
				if (quartos[i].getOcupacao() == 0) {
					System.out.print(" " + i);
				}
			}
			i++;
		}
		System.out.println();
	}
	
	public int obterNumDisponiveis() {
		int quantidade = 0;
		int i = 0;
		while (i < quartos.length) {
			if (quartos[i] != null) {
				if (quartos[i].getOcupacao() == 0) {
					quantidade ++;
				}
			}
			i++;
		}
		return quantidade;
	}
	
	public double obterPreco(int numQuarto) {
		if (quartos[numQuarto].getVip() == 1) {
			return this.precoVip;
		} else {
			return this.precoNormal;
		}
	}
	
	public void obterServicos(int numQuarto) {
		if (quartos[numQuarto].getArCondicionado() == 1) {
			System.out.println("Quarto " + numQuarto + ": Possui ar condicionado.");
		} else {
			System.out.println("Quarto " + numQuarto + ": Nao possui ar condicionado.");
		}
		if (quartos[numQuarto].getFumante() == 1) {
			System.out.println("Quarto " + numQuarto + ": Aceita fumantes");
		} else {
			System.out.println("Quarto " + numQuarto + ": Nao aceita fumantes");
		}
	}
	
	public Room[] getQuartos() {
		return this.quartos;
	}
	
	public int getQuantidadeQuartos() {
		return this.quantidadeQuartos;
	}

}