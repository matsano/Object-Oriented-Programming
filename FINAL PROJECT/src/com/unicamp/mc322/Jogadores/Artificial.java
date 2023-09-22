package com.unicamp.mc322.Jogadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.unicamp.mc322.Cartas.*;

public class Artificial extends Jogador {
	
	public Artificial() {
		super();
		nome = "Computador";
	}
	
	//inicio da substituicao de cartas
	private void substituirCartasAleatorias(int quantidadeCartas) {
		int quantidade = 0;
		int posicaoCarta = 0;
		Carta novaCarta;
		Random aleatorio = new Random();
		while (quantidade < quantidadeCartas) {
			posicaoCarta = aleatorio.nextInt(4);
			novaCarta = pegarCartaAleatoriaDoDeck();
			this.cartasSelecionadas.set(posicaoCarta, novaCarta);
			quantidade += 1;
		}
	}
	
	public void substituirCartasSelecionadas() {
		Random aleatorio = new Random();
		int quantidadeCartas = aleatorio.nextInt(5);
		substituirCartasAleatorias(quantidadeCartas);
	}
	//fim da substituicao das cartas
	
	//inicio da evocacao de cartas
	protected UnidadeEvocada escolherCartaDasEvocadas() {
		Random aleatorio = new Random();
		int posicaoCarta = aleatorio.nextInt(6);
		return this.unidadesEvocadas.get(posicaoCarta);
	}
	
	private ArrayList<Carta> obterCartasPossiveisDeCompra() {
		ArrayList<Carta> cartasPossiveisDeCompra = new ArrayList<Carta>();
		int diferencaPontosMana = 0;
		for (int posicaoCarta = 0; posicaoCarta < this.cartasSelecionadas.size(); posicaoCarta++) {
			diferencaPontosMana = this.cartasSelecionadas.get(posicaoCarta).obterDiferencaDoCustoMana(this.pontosMana);
			if (diferencaPontosMana >= 0) {
				cartasPossiveisDeCompra.add(this.cartasSelecionadas.get(posicaoCarta));
			}
		}
		return cartasPossiveisDeCompra;
	}
	
	private void comprarFeitico() {
		Random aleatorio = new Random();
		boolean escolha = aleatorio.nextBoolean();
		if ((escolha) && (this.pontosMana >= 3)) {
			this.comprarCartaFeitico();
		}
	}
	
	private void comprarCartaAleatoriamente() {
		ArrayList<Carta> cartasPossiveisDeCompra = obterCartasPossiveisDeCompra();
		this.comprarFeitico();
		if (cartasPossiveisDeCompra.size() != 0) {
			Random aleatorio = new Random();
			int posicaoCarta = aleatorio.nextInt(cartasPossiveisDeCompra.size());
			Carta cartaSelecionada = cartasPossiveisDeCompra.get(posicaoCarta);
			comprarCarta(cartaSelecionada);
			this.ativarEfeitosCarta(cartaSelecionada);
		}
	}
		
	public void comprarCartaOuPassarVez() {
		Random aleatorio = new Random();
		boolean opcaoEscolhida = aleatorio.nextBoolean();
		if (opcaoEscolhida == true) {
			this.comprarCartaAleatoriamente();
		}
	}
	//final da evocacao de cartas
	
	//inicio da escolha de cartas para batalha
	private boolean escolherBatalhar() {
		Random aleatorio = new Random();
		return aleatorio.nextBoolean();
	}
	
	public boolean escolherAtacar() {
		return escolherBatalhar();
	}
	
	public boolean escolherDefender() {
		return escolherBatalhar();
	}
	
	public ArrayList<UnidadeEvocada> obterCartasParaBatalha(){
		if (this.unidadesEvocadas.size() != 0) {
			Random aleatorio = new Random();
			int posicaoCarta;
			int quantidade = 0;
			int quantidadeCartasParaBatalha = aleatorio.nextInt(this.unidadesEvocadas.size()) + 1;
			while (quantidade < quantidadeCartasParaBatalha) {
				posicaoCarta = aleatorio.nextInt(this.unidadesEvocadas.size());
				this.cartasParaBatalha.add(this.unidadesEvocadas.get(posicaoCarta));
				this.unidadesEvocadas.remove(posicaoCarta);
				quantidade += 1;
			}
		}
		return this.cartasParaBatalha;
	}
	
	private ArrayList<Integer> obterSequenciaAleatoria(ArrayList<UnidadeEvocada> cartasDoAtacante) {
		ArrayList<Integer> sequenciaAleatoria = new ArrayList<Integer>();
		for (int posicao = 0; posicao < cartasDoAtacante.size(); posicao++) {
			sequenciaAleatoria.add(posicao);
		}
		Collections.shuffle(sequenciaAleatoria);
		return sequenciaAleatoria;
	}
	
	public ArrayList<UnidadeEvocada> obterCartasParaDefesa(ArrayList<UnidadeEvocada> cartasDoAtacante){
		ArrayList<UnidadeEvocada> cartasParaDefesa = (ArrayList<UnidadeEvocada>) obterCartasParaBatalha().clone();
		ArrayList<Integer> posicoesAleatorias = obterSequenciaAleatoria(cartasDoAtacante);
		int contador = 0;
		int posicaoEscolhida = 0;
		while (contador < cartasParaDefesa.size()) {
			posicaoEscolhida = posicoesAleatorias.get(contador);
			this.cartasParaBatalha.set(posicaoEscolhida, cartasParaDefesa.get(contador));
			contador += 1;
		}
		return this.cartasParaBatalha;
	}	
	//fim da escolha de cartas para batalha		
}