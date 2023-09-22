package com.unicamp.mc322.lab05;

public class Participante {
	
	private String nome;
	private String email;
	private String telefoneDeContato;
	private boolean confirmado;
	
	public Participante (String name, String endEletronico, String telefone) {
		nome = name;
		email = endEletronico;
		telefoneDeContato = telefone;
		confirmado = false;
	}
	
	public void setConfirmado(boolean situacao) {
		this.confirmado = situacao;
	}
	
	public void imprimirParticipante() {
		System.out.println("  - Nome: " + this.nome);
		System.out.println("	E-mail: " + this.email);
		System.out.println("	Telefone de contato: " + this.telefoneDeContato);
		System.out.print("	Presenca: ");
		if (this.confirmado == true) {
			System.out.println("CONFIRMADA");
		} else {
			System.out.println("NAO CONFIRMADA");
		}
	}
}