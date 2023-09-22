package com.unicamp.mc322.lab07.Elementos;

import java.util.ArrayList;

public abstract class Ra extends Elemento {
	
	protected String nome;
	protected Posicao posicaoAnterior;
	protected  double pontosObtidos;
	private ArrayList<Comida> comidasIngeridas = new ArrayList();
	protected boolean vida;
	
	protected Ra (int aLinha, int aColuna, String oNome) {
		adicionarPosicao(new Posicao(aLinha,aColuna));
		nome = oNome;
		icone = "J1";
		vida = true;
		posicaoAnterior = new Posicao(aLinha, aColuna);
		pontosObtidos = 0;
	}
	
	public abstract void calcularPontosObtidos(Comida comida);
	
	public abstract void moverCima();
	
	public abstract void moverBaixo();
	
	public abstract void moverDireita();
	
	public abstract void moverEsquerda();
	
	protected void atualizarPosicaoAnterior() {
		this.posicaoAnterior.atualizarPosicao(this.posicoes.get(0));
	}
	
	public void morreu() {
		this.vida = false;
	}
	
	public boolean ehPosicaoDaRa(int umaLinha, int umaColuna) {
		boolean raEstaNessaPosicao = false;
		if (umaLinha == this.posicoes.get(0).getLinha()) {
			if (umaColuna == this.posicoes.get(0).getColuna()) {
				raEstaNessaPosicao = true;
			}
		}
		return raEstaNessaPosicao;
	}
	
	public boolean estaVivo() {
		return this.vida;
	}
	
	public void adicionarComidaIngerida(Comida comida) {
		this.comidasIngeridas.add(comida);
	}
	
	private void imprimirComidasIngeridas() {
		if (this.comidasIngeridas != null) {
			int numeroComidasIngeridas = 0;
			while (numeroComidasIngeridas < this.comidasIngeridas.size()) {
				System.out.print("		" + this.comidasIngeridas.get(numeroComidasIngeridas).getNome() + ": ");
				System.out.println(this.comidasIngeridas.get(numeroComidasIngeridas).getPontosSatisfacao());
				numeroComidasIngeridas += 1;
			}
		}
	}
	
	public void imprimirResultados() {
		System.out.println("Resultado:");
		System.out.println(this.nome + " (" + this.icone + ")");
		System.out.println("	- Pontos obtidos: " + this.pontosObtidos);
		imprimirComidasIngeridas();
	}
}
