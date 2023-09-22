package com.unicamp.mc322.Jogadores;

import java.util.ArrayList;
import java.util.Scanner;
import com.unicamp.mc322.Cartas.*;

public class Humano extends Jogador {
	
	public Humano(String umNome) {
		super();
		nome = umNome;
	}
	
	private void imprimirDetalhamentoCartasSelecionadas() {
		int posicao = 0;
		while (posicao < this.cartasSelecionadas.size()) {
			this.cartasSelecionadas.get(posicao).imprimirInformacaoCompleta();
			posicao += 1;
		}
	}
	
	private void imprimirDetalhamento(ArrayList<UnidadeEvocada> cartas) {
		int posicao = 0;
		while (posicao < cartas.size()) {
			cartas.get(posicao).imprimirInformacaoCompleta();
			posicao += 1;
		}
	}
	
	private void imprimirDetalhamentoDasCartas() {
		System.out.println("---------- Cartas Selecionadas ----------");
		this.imprimirDetalhamentoCartasSelecionadas();
		System.out.println("---------- Unidades evocadas ----------");
		this.imprimirDetalhamento(this.unidadesEvocadas);
		System.out.println("---------- Cartas para batalha ----------");
		this.imprimirDetalhamento(this.cartasParaBatalha);
	}
	
	private void verDetalhamentoDasCartas() {
		Scanner input = new Scanner(System.in);
		System.out.println("Deseja ver detalhamento das cartas? Tecle 1          Não ver detalhamento? Tecle 0");
		int escolha = input.nextInt();
		if (escolha == 1) {
			this.imprimirDetalhamentoDasCartas();
		}
	}
	
	//inicio da substituicao de cartas
	private void substituirCartas(int quantidadeCartas) {
		int quantidade = 0;
		int posicaoCarta = 0;
		Carta novaCarta;
		Scanner input = new Scanner(System.in);
		while (quantidade < quantidadeCartas) {
			System.out.print("Qual numero da carta que deseja substituir? Carta 1, 2, 3 ou 4? ");
			posicaoCarta = input.nextInt() - 1;
			novaCarta = pegarCartaAleatoriaDoDeck();
			this.cartasSelecionadas.set(posicaoCarta, novaCarta);
			quantidade += 1;
		}
	}
	
	public void substituirCartasSelecionadas() {
		Scanner input = new Scanner(System.in);
		this.imprimirNome();
		this.imprimirCartasSelecionadas();
		this.verDetalhamentoDasCartas();
		System.out.print("Quantas cartas deseja substituir? ");
		int quantidadeCartas = input.nextInt();
		substituirCartas(quantidadeCartas);
		this.imprimirCartasSelecionadas();
	}
	//final da substituicao de cartas
	
	//inicio da compra de cartas
	protected UnidadeEvocada escolherCartaDasEvocadas() {
		Scanner input = new Scanner(System.in);
		System.out.print("Qual carta evocada quer que seja substituida? Carta ");
		int posicaoCarta = input.nextInt() - 1;
		return this.unidadesEvocadas.get(posicaoCarta);
	}
	
	private void comprarFeitico() {
		Scanner input = new Scanner(System.in);
		System.out.println("Comprar uma carta Feitico (Custo: 3 manas)? Insira 1 para comprar e 0 para nao comprar.");
		int escolha = input.nextInt();
		if ((escolha == 1) && (this.pontosMana >= 3)) {
			this.comprarCartaFeitico();
		}
	}
	
	private void comprarUmaCarta() {
		Scanner input = new Scanner(System.in);
		int posicaoCarta = 0;
		Carta cartaSelecionada;
		boolean turnoTerminado = false;
		this.comprarFeitico();
		while (!turnoTerminado) {
			System.out.println("Qual carta comprar? Insira 0 para terminar seu turno.");
			posicaoCarta = input.nextInt() - 1;			
			if (posicaoCarta != -1) {
				cartaSelecionada = this.cartasSelecionadas.get(posicaoCarta);
				if (podeComprar(cartaSelecionada)) {
					comprarCarta(cartaSelecionada);
					this.ativarEfeitosCarta(cartaSelecionada);
					turnoTerminado = true;
				}
			} else {
				turnoTerminado = true;
			}
		}
	}
	
	public void comprarCartaOuPassarVez() {
		this.imprimirNome();
		Scanner input = new Scanner(System.in);
		this.verDetalhamentoDasCartas();
		System.out.println("Comprar carta? Tecle 1        Passar vez? Tecle 2");
		int opcaoEscolhida = input.nextInt();
		if (opcaoEscolhida == 1) {
			this.comprarUmaCarta();
		}
	}
	//final da compra de cartas
	
	//inicio da escolha de cartas para batalha
	private boolean escolherBatalhar() {
		Scanner input = new Scanner(System.in);
		int opcaoEscolhida = input.nextInt();
		if (opcaoEscolhida == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean escolherAtacar() {
		this.imprimirNome();
		if (this.unidadesEvocadas.size() != 0) {
			this.verDetalhamentoDasCartas();
			System.out.println("Atacar? Tecle 1        Passar vez? Tecle 2");
			return escolherBatalhar();
		} else {
			System.out.println("Sem unidades evocadas. Passar vez");
			return false;
		}
	}
	
	public boolean escolherDefender() {
		this.imprimirNome();
		this.verDetalhamentoDasCartas();
		System.out.println("Defender? Tecle 1        Passar vez? Tecle 2");
		return escolherBatalhar();
	}
	
	public ArrayList<UnidadeEvocada> obterCartasParaBatalha() {
		Scanner input = new Scanner(System.in);
		boolean escolhaFinalizada = false;
		ArrayList<UnidadeEvocada> unidadesProvisorias = (ArrayList<UnidadeEvocada>) this.unidadesEvocadas.clone();
		while ((!escolhaFinalizada) && (unidadesProvisorias.size() != 0)) {
			System.out.println("Qual carta escolhe para batalha? Insira 0 para terminar seu turno.");
			int posicaoCarta = input.nextInt() - 1;			
			if (posicaoCarta != -1) {
				UnidadeEvocada cartaEscolhida = this.unidadesEvocadas.get(posicaoCarta);
				this.cartasParaBatalha.add(cartaEscolhida);
				unidadesProvisorias.remove(cartaEscolhida);
			} else {
				escolhaFinalizada = true;
			}
		}
		this.unidadesEvocadas = unidadesProvisorias;
		return this.cartasParaBatalha;
	}
	
	public ArrayList<UnidadeEvocada> obterCartasParaDefesa(ArrayList<UnidadeEvocada> cartasDoAtacante){
		Scanner input = new Scanner(System.in);
		ArrayList<UnidadeEvocada> cartasParaDefesa = (ArrayList<UnidadeEvocada>) obterCartasParaBatalha().clone();
		int contador = 0;
		int posicaoEscolhida = 0;
		while ((contador < cartasDoAtacante.size()) && (contador < cartasParaDefesa.size())) {
			cartasParaDefesa.get(contador).imprimirInformacaoCompleta();
			System.out.println("De qual carta adversaria quer se defender? ");
			posicaoEscolhida = input.nextInt() - 1;
			this.cartasParaBatalha.set(posicaoEscolhida, cartasParaDefesa.get(contador));
			contador += 1;
		}
		
		return this.cartasParaBatalha;
	}
}