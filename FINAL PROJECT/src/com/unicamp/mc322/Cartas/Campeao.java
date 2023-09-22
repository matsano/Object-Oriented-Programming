package com.unicamp.mc322.Cartas;

import com.unicamp.mc322.Cartas.Tracos.*;
import com.unicamp.mc322.Cartas.MelhoriasNivelSuperior.*;
import java.util.ArrayList;

public class Campeao extends UnidadeEvocada {
	
	private NivelDoCampeao nivel;
	private CondicaoSubirNivel condicaoSubirNivel;
	private int quantidadeDaCondicao;
	private int quantidadeAtaques;
	private int quantidadeSeguidoresAdversariosMortos;
	private int quantidadeDanoCausado;
	private ArrayList<Melhoria> melhorias;
	
	public Campeao(String umNome, int custo, int valorPoder, int valorVida, CondicaoSubirNivel condicao, int quantidade) {
		super(umNome, custo, valorPoder, valorVida);
		nivel = NivelDoCampeao.NORMAL;
		condicaoSubirNivel = condicao;
		quantidadeDaCondicao = quantidade;
		quantidadeAtaques = 0;
		quantidadeSeguidoresAdversariosMortos = 0;
		quantidadeDanoCausado = 0;
		melhorias = new ArrayList<Melhoria>();
	}
	
	public Campeao(String umNome, int custo, int valorPoder, int valorVida, CondicaoSubirNivel condicao, int quantidade, Traco umTraco) {
		this(umNome, custo, valorPoder, valorVida, condicao, quantidade);
		Traco traco = umTraco.clonar();
		this.tracos.add(traco);
	}
	
	public static boolean ehCampeao(Carta carta) {
		return carta instanceof Campeao;
	}
	
	public void adicionarMelhoria(Melhoria melhoria) {
		this.melhorias.add(melhoria);
	}
	
	public void adicionarPoder(int poderSomado) {
		this.poder += poderSomado;
	}
	
	public void adicionarVida(int vidaSomada) {
		this.vida += vidaSomada;
	}
	
	public void adicionarTraco(Traco novoTraco) {
		Traco traco = novoTraco.clonar();
		this.tracos.add(traco);
	}
	
	private void melhorarNivel() {
		this.nivel = NivelDoCampeao.SUPERIOR;
		for (int posicaoMelhoria = 0; posicaoMelhoria < this.melhorias.size(); posicaoMelhoria++) {
			this.melhorias.get(posicaoMelhoria).aplicar();
		}
	}
	
	public void atualizarInformacoesAtacante() {
		this.quantidadeAtaques += 1;
		this.quantidadeDanoCausado += this.poderNaBatalha;
	}
	
	public void atualizarInformacoesAtacante(UnidadeEvocada defensor) {
		this.atualizarInformacoesAtacante();
		if (defensor.estaDestruida()) {
			this.quantidadeSeguidoresAdversariosMortos += 1;
		}
	}
	
	/*condicoes para subir de nivel*/
	private void verificarQuantidadeAtaques() {
		if (this.quantidadeDaCondicao == this.quantidadeAtaques) {
			melhorarNivel();
		}
	}
	
	private void verificarQuantidadeSeguidoresMortos() {
		if (this.quantidadeDaCondicao == this.quantidadeSeguidoresAdversariosMortos) {
			melhorarNivel();
		}
	}
	
	private void verificarPontosDanoFeitos() {
		if (this.quantidadeDanoCausado == this.quantidadeDaCondicao) {
			melhorarNivel();
		}
	}
	
	private void verificarPontosDanoSofridos() {
		if ((this.poderInicial - this.poder) == this.quantidadeDaCondicao) {
			melhorarNivel();
		}
	}
	
	public void verificarCondicao() {
		switch(this.condicaoSubirNivel) {
		case ATACAR_N_VEZES:
			verificarQuantidadeAtaques();
			break;
		case MATAR_N_SEGUIDORES:
			verificarQuantidadeSeguidoresMortos();
			break;
		case FAZER_N_PONTOS_DANO:
			verificarPontosDanoFeitos();
			break;
		case SOFRER_N_PONTOS_DANO:
			verificarPontosDanoSofridos();
			break;
		}
	}
	/*fim das condicoes para subir nivel*/
	
	private void imprimirNivel() {
		System.out.print("Nivel: ");
		if (this.nivel == NivelDoCampeao.NORMAL) {
			System.out.println("NORMAL");
		} else {
			System.out.println("SUPERIOR");
		}
	}
	
	private void imprimirCondicaoParaSubirNivel() {
		System.out.print("Condicao para subir de nivel: ");
		if (this.condicaoSubirNivel == CondicaoSubirNivel.ATACAR_N_VEZES) {
			System.out.println("atacar " + this.quantidadeDaCondicao + " vezes");
		} else if (this.condicaoSubirNivel == CondicaoSubirNivel.FAZER_N_PONTOS_DANO) {
			System.out.println("fazer " + this.quantidadeDaCondicao + " pontos de dano no adversario");
		} else if (this.condicaoSubirNivel == CondicaoSubirNivel.MATAR_N_SEGUIDORES) {
			System.out.println("matar " + this.quantidadeDaCondicao + " seguidores adversarios");
		} else {
			System.out.println("sofrer " + this.quantidadeDaCondicao + " pontos de dano");
		}
	}
	
	public void imprimirInformacaoAdicional() {
		System.out.println("Tipo: CAMPEAO");
		imprimirNivel();
		imprimirCondicaoParaSubirNivel();
		imprimirPoderVida();
		imprimirTracos();
		imprimirEfeitos();
	}
	
}
