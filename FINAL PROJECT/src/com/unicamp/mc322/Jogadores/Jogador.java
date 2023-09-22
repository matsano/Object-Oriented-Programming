package com.unicamp.mc322.Jogadores;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import com.unicamp.mc322.Cartas.*;
import com.unicamp.mc322.Deck.*;

public abstract class Jogador {
	
	protected String nome;
	protected int pontosMana;
	private int nexus;
	protected StatusJogador status;
	private Jogador adversario;
	protected ArrayList<Carta> deck = new ArrayList<Carta>();
	private FactoryDeck factory = new FactoryDeck();
	protected ArrayList<Carta> cartasSelecionadas = new ArrayList<Carta>();
	protected ArrayList<UnidadeEvocada> unidadesEvocadas = new ArrayList<UnidadeEvocada>();
	protected ArrayList<UnidadeEvocada> cartasParaBatalha = new ArrayList<UnidadeEvocada>();
	
	protected Jogador() {
		pontosMana = 0;
		nexus = 20;
	}
	
	public void obterDeck() {
		this.factory.getDeck("Demacia");
		this.deck = this.factory.obterDeck();
	}
	
	public abstract void substituirCartasSelecionadas();
	
	public abstract void comprarCartaOuPassarVez();
	
	protected abstract UnidadeEvocada escolherCartaDasEvocadas();
	
	public abstract boolean escolherAtacar();
	
	public abstract boolean escolherDefender();
	
	public abstract ArrayList<UnidadeEvocada> obterCartasParaBatalha();
	
	public abstract ArrayList<UnidadeEvocada> obterCartasParaDefesa(ArrayList<UnidadeEvocada> cartasDoAtacante);
	
	//metodos do comeco de partida	
	private void embaralharDeck() {
		Collections.shuffle(deck);
	}
	
	public void ehAtacante() {
		this.status = StatusJogador.ATACANTE;
	}
	
	public void ehDefensor() {
		this.status = StatusJogador.DEFENSOR;
	}
	
	public void determinarAdversario(Jogador umAdversario) {
		this.adversario = umAdversario;
	}
	
	protected Carta pegarCartaAleatoriaDoDeck() {
		Random aleatorio = new Random();
		int limiteNumeroAleatorio = this.deck.size();
		int numeroAleatorio = aleatorio.nextInt(limiteNumeroAleatorio);
		Carta novaCarta = this.deck.get(numeroAleatorio);
		while (novaCarta.temEssaCarta(this.cartasSelecionadas)) {
			numeroAleatorio = aleatorio.nextInt(limiteNumeroAleatorio);
			novaCarta = this.deck.get(numeroAleatorio);
		}
		return novaCarta;
	}
	
	private void pegarQuatroCartasAleatoriasDoDeck() {
		while (this.cartasSelecionadas.size() != 4) {
			Carta carta = pegarCartaAleatoriaDoDeck();
			this.cartasSelecionadas.add(carta);
			this.deck.remove(carta);
		}
	}
	
	public void obterCartasDoDeck() {
		embaralharDeck();
		pegarQuatroCartasAleatoriasDoDeck();
	}
	//fim dos metodos do comeco de partida
	
	public void obterCartaDoTopoDoDeck() {
		int posicaoCarta = 0;
		Carta novaCarta = this.deck.get(posicaoCarta);
		while(novaCarta.temEssaCarta(this.cartasSelecionadas)) {
			posicaoCarta += 1;
			novaCarta = this.deck.get(posicaoCarta);
		}
		this.cartasSelecionadas.add(novaCarta);
		this.deck.remove(novaCarta);
	}
	
	public void receberPontosMana(int pontosManaAdicionais) {
		if (pontosManaAdicionais < 10) {
			this.pontosMana += pontosManaAdicionais;
		} else {
			this.pontosMana += 10;
		}
	}
	
	public void limitarPontosMana() {
		if (this.pontosMana > 3) {
			this.pontosMana = 3;
		}
	}
	
	protected boolean podeComprar(Carta carta) {
		int pontosManaAtualizado = this.pontosMana - carta.getCustoMana();
		if (pontosManaAtualizado >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void substituirCartaDasEvocadas(UnidadeEvocada novaCarta, UnidadeEvocada cartaSubstituida) {
		this.cartasSelecionadas.add(cartaSubstituida);
		this.unidadesEvocadas.remove(cartaSubstituida);
		this.unidadesEvocadas.add(novaCarta);
		this.cartasSelecionadas.remove(novaCarta);
		this.pontosMana = this.pontosMana + cartaSubstituida.getCustoMana() - novaCarta.getCustoMana();
	}
	
	private void ativarEfeitosUnidadesEvocadas() {
		int posicao = 0;
		while (posicao < this.unidadesEvocadas.size()) {
			this.unidadesEvocadas.get(posicao).ativarEfeitos(this.unidadesEvocadas, this.adversario, this);
			posicao += 1;
		}
	}
	
	private void ativarEfeitosCartasNaBatalha() {
		int posicao = 0;
		while (posicao < this.cartasParaBatalha.size()) {
			this.cartasParaBatalha.get(posicao).ativarEfeitos(this.unidadesEvocadas, this.adversario, this);
			posicao += 1;
		}
	}
	
	public void ativarEfeitos() {
		this.ativarEfeitosUnidadesEvocadas();
		this.ativarEfeitosCartasNaBatalha();
	}
	
	protected void ativarEfeitosCarta(Carta carta) {
		carta.ativarEfeitos(this.unidadesEvocadas, this.adversario, this);
	}
	
	protected void comprarCarta(Carta carta) {
		if (UnidadeEvocada.ehUnidadeEvocada(carta)) {
			UnidadeEvocada unidadeEvocada = (UnidadeEvocada)carta;
			if (this.unidadesEvocadas.size() < 6) {
				this.unidadesEvocadas.add(unidadeEvocada);
				this.cartasSelecionadas.remove(unidadeEvocada);
				this.pontosMana -= carta.getCustoMana();
			} else {
				UnidadeEvocada cartaSubstituida = escolherCartaDasEvocadas();
				substituirCartaDasEvocadas(unidadeEvocada, cartaSubstituida);
			}
		}
		this.cartasSelecionadas.remove(carta);
	}
	
	protected void comprarCartaFeitico() {
		boolean cartaComprada = false;
		int posicao = 0;
		while ((!cartaComprada) && (posicao < this.deck.size())) {
			Carta carta = this.deck.get(posicao);
			if (Feitico.ehFeitico(carta)) {
				this.ativarEfeitosCarta(carta);
				this.deck.remove(carta);
			}
		}
	}
	
	public void sofrerDanoNoNexus(int pontosDano) {
		this.nexus -= pontosDano;
	}
	
	public void atacarNexus(Jogador defensor) {
		int posicao = 0;
		while (posicao < this.cartasParaBatalha.size()) {
			defensor.sofrerDanoNoNexus(this.cartasParaBatalha.get(posicao).getPoderNaBatalha());
			posicao += 1;
		}
	}
	
	public void retornarCartasEntreUnidadesEvocadas(ArrayList<UnidadeEvocada> cartasDaBatalha) {
		for (int posicaoCarta = 0; posicaoCarta < cartasDaBatalha.size(); posicaoCarta++) {
			this.unidadesEvocadas.add(cartasDaBatalha.get(posicaoCarta));
		}
		this.cartasParaBatalha.clear();
	}
	
	public boolean estaMorto() {
		if (this.nexus <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void atualizarPoderCartas() {
		int posicao = 0;
		while (posicao < this.unidadesEvocadas.size()) {
			UnidadeEvocada carta = this.unidadesEvocadas.get(posicao);
			carta.atualizarPoder();
			if (Campeao.ehCampeao(carta)) {
				Campeao cartaCampeao = (Campeao) carta;
				cartaCampeao.verificarCondicao();
			}
			posicao += 1;
		}
	}
	
	//inicio das acoes dos efeitos
	public void defenderDeCombateImediato(UnidadeEvocada cartaAdversariaAtacante) {
		if (this.unidadesEvocadas.size() != 0) {
			Random aleatorio = new Random();
			int posicaoDefensor = aleatorio.nextInt(this.unidadesEvocadas.size());
			cartaAdversariaAtacante.atacar(this.unidadesEvocadas.get(posicaoDefensor));
		} else {
			this.sofrerDanoNoNexus(cartaAdversariaAtacante.getPoderNaBatalha());
		}
	}
	
	public void defenderDeAtaques(UnidadeEvocada cartaAdversariaAtacante) {
		if (this.unidadesEvocadas.size() != 0) {
			for (int posicao = 0; posicao < this.unidadesEvocadas.size(); posicao++) {
				cartaAdversariaAtacante.atacar(this.unidadesEvocadas.get(posicao));
			}
		} else {
			this.sofrerDanoNoNexus(cartaAdversariaAtacante.getPoderNaBatalha());
		}
	}
	
	public void zerarPoderNaBatalha() {
		if (this.unidadesEvocadas.size() != 0) {
			Random aleatorio = new Random();
			int posicaoDefensor = aleatorio.nextInt(this.unidadesEvocadas.size());
			this.unidadesEvocadas.get(posicaoDefensor).zerarPoderNaBatalha();
		}
	}
	
	//fim das acoes dos efeitos
	
	protected void imprimirNome() {
		System.out.println("Turno: " + this.nome);
		System.out.println();
	}
	
	private void imprimirCartas(ArrayList<Carta> cartas) {
		int numeroDaCarta = 0;
		for (int posicaoCarta = 0; posicaoCarta < cartas.size(); posicaoCarta++) {
			numeroDaCarta = posicaoCarta + 1;
			System.out.print("Carta " + numeroDaCarta + ": ");
			cartas.get(posicaoCarta).imprimirInformacaoReduzida();
			if (posicaoCarta == (cartas.size()-1)) {
				System.out.println();
				System.out.println();
			} else {
				System.out.print("       ");
			}
		}
	}
	
	private void imprimirCartasEvocadas(ArrayList<UnidadeEvocada> cartas) {
		int numeroDaCarta = 0;
		for (int posicaoCarta = 0; posicaoCarta < cartas.size(); posicaoCarta++) {
			numeroDaCarta = posicaoCarta + 1;
			System.out.print("Carta " + numeroDaCarta + ": ");
			cartas.get(posicaoCarta).imprimirInformacaoReduzida();
			if (posicaoCarta == (cartas.size()-1)) {
				System.out.println();
				System.out.println();
			} else {
				System.out.print("       ");
			}
		}
	}
	
	public void imprimirCartasSelecionadas() {
		System.out.println("Cartas selecionadas:");
		this.imprimirCartas(this.cartasSelecionadas);
	}
	
	public void imprimirUnidadesEvocadas() {
		System.out.println("Unidades evocadas:");
		this.imprimirCartasEvocadas(this.unidadesEvocadas);
	}
	
	public void imprimirCartasParaBatalha() {
		System.out.println("Cartas Batalha:");
		this.imprimirCartasEvocadas(this.cartasParaBatalha);
	}
	
	public void imprimirInformacoes() {
		System.out.print("--- Cartas Jogador " + this.nome + " ");
		System.out.println("(Mana: "+ this.pontosMana + "/ Nexus: " + this.nexus + ") ---");
	}
}
