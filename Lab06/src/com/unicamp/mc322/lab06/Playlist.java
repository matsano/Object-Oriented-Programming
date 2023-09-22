package com.unicamp.mc322.lab06;

import java.util.Random;
import java.util.ArrayList;

public class Playlist {
	
	private String nome;
	private ArrayList<Entretenimento> entretenimentos;
	private int entretenimentoAtual;
	private double tamanhoTotal;
	private double tamanhoOcupado;
	private User dono;
	Random random = new Random();
	
	public Playlist(String theName, double tamanho) {
		nome = theName;
		entretenimentos = new ArrayList();
		entretenimentoAtual = 0;
		tamanhoTotal = tamanho;
		tamanhoOcupado = 0;
		dono = null;
	}
	
	private boolean possuiLimiteTamanho() {
		boolean condicao = false;
		int posicaoEntretenimento = 0;
		
		while((condicao == false) && (posicaoEntretenimento < this.entretenimentos.size())) {
			if (this.entretenimentos.get(posicaoEntretenimento).getDuracao() >= 60.0) {
				condicao = true;
			} else {
				posicaoEntretenimento += 1;
			}
		}
		return condicao;
	}
	
	public void adicionarEntretenimento(Entretenimento entretenimento) {
		double novoTamanho = 0;
		if (possuiLimiteTamanho() == true) {
			novoTamanho = entretenimento.getArmazenamento();
			if ((this.tamanhoOcupado + novoTamanho < this.tamanhoTotal) && (this.dono.temEspaco(entretenimento) == true)) {
				this.tamanhoOcupado += novoTamanho;
				this.entretenimentos.add(entretenimento);
				this.dono.aumentarArmazenamentoOcupado(novoTamanho);
			}
		} else {
			novoTamanho = entretenimento.getArmazenamento();
			this.entretenimentos.add(entretenimento);
			this.tamanhoOcupado += novoTamanho;
			this.dono.aumentarArmazenamentoOcupado(novoTamanho);
		}
	}
	
	public void removerEntretenimento(Entretenimento entretenimento) {
		double novoTamanho = entretenimento.getArmazenamento();
		this.entretenimentos.remove(entretenimento);
		this.tamanhoOcupado -= novoTamanho;
		this.dono.diminuirArmazenamentoOcupado(novoTamanho);
	}
	
	public String obterItemMenorDuracao() {
		Entretenimento menorDuracao = this.entretenimentos.get(0);
		for (int numeroEntretenimento = 0; numeroEntretenimento < this.entretenimentos.size(); numeroEntretenimento++) {
			menorDuracao = menorDuracao.obterDuracaoMenor(this.entretenimentos.get(numeroEntretenimento));
		}
		return menorDuracao.getNome();
	}
	
	public String obterItemMaiorDuracao() {
		Entretenimento maiorDuracao = this.entretenimentos.get(0);
		for (int numeroEntretenimento = 0; numeroEntretenimento < this.entretenimentos.size(); numeroEntretenimento++) {
			maiorDuracao = maiorDuracao.obterDuracaoMaior(this.entretenimentos.get(numeroEntretenimento));
		}
		return maiorDuracao.getNome();
	}
	
	public double obterDuracaoTotal() {
		int tempoTotal = 0;
		for (int numeroEntretenimento = 0; numeroEntretenimento < this.entretenimentos.size(); numeroEntretenimento++) {
			tempoTotal += this.entretenimentos.get(numeroEntretenimento).getDuracao();
		}
		return tempoTotal;
	}
	
	public double obterDuracaoMedia() {
		return obterDuracaoTotal() / this.entretenimentos.size();
	}
	
	public Entretenimento play(boolean shuffle) {
		if (shuffle == false) {
			if (this.entretenimentoAtual+1 == this.entretenimentos.size()) {
				this.entretenimentoAtual = 0;
			} else {
				this.entretenimentoAtual += 1;
			}
		} else {
			int proximoEntretenimento = this.entretenimentoAtual;
			while (proximoEntretenimento == this.entretenimentoAtual) {
				proximoEntretenimento = random.nextInt(this.entretenimentos.size()-1);
			}
			this.entretenimentoAtual = proximoEntretenimento;
		}
		return this.entretenimentos.get(this.entretenimentoAtual);
	}
	
	public double getTamanhoOcupado() {
		return this.tamanhoOcupado;
	}
	
	public void setDono(User usuario) {
		this.dono = usuario;
	}
	
	public int getEntretenimentoAtual() {
		return this.entretenimentoAtual;
	}
}