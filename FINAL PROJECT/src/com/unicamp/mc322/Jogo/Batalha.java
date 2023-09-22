package com.unicamp.mc322.Jogo;

import java.util.ArrayList;
import com.unicamp.mc322.Jogadores.Jogador;
import com.unicamp.mc322.Cartas.*;

public class Batalha {
	
	private Jogador atacante;
	private Jogador defensor;
	private ArrayList<UnidadeEvocada> cartasDoAtacante = new ArrayList<UnidadeEvocada>();
	private ArrayList<UnidadeEvocada> cartasDoDefensor = new ArrayList<UnidadeEvocada>();
	private Mesa mesa;
	
	public Batalha(Mesa mesaDaBatalha) {
		mesa = mesaDaBatalha;
	}
	
	public void determinarAtacante(Jogador jogador) {
		this.atacante = jogador;
		jogador.ehAtacante();
	}
	
	public void determinarDefensor(Jogador jogador) {
		this.defensor = jogador;
		jogador.ehDefensor();
	}
	
	private void prepararBatalha() {
		this.atacante.comprarCartaOuPassarVez(); //turno 1
		this.mesa.imprimir();
		this.defensor.comprarCartaOuPassarVez(); //turno 2
		this.mesa.imprimir();
	}
	
	private void atualizarInformacoesCampeaoAtacante(UnidadeEvocada atacante, UnidadeEvocada defensor) {
		if (Campeao.ehCampeao(atacante)) {
			Campeao cartaAtacante = (Campeao) atacante;
			if (Seguidor.ehSeguidor(defensor)) {
				cartaAtacante.atualizarInformacoesAtacante(defensor);
			} else {
				cartaAtacante.atualizarInformacoesAtacante();
			}
		}
	}
	
	private void realizarAtaque() {
		for (int posicaoCarta = 0; posicaoCarta < this.cartasDoAtacante.size(); posicaoCarta++) {
			if (posicaoCarta < this.cartasDoDefensor.size()) {
				this.cartasDoAtacante.get(posicaoCarta).aplicarTracos(this.cartasDoDefensor.get(posicaoCarta));
				this.cartasDoAtacante.get(posicaoCarta).atacar(this.cartasDoDefensor.get(posicaoCarta));
				this.atualizarInformacoesCampeaoAtacante(this.cartasDoAtacante.get(posicaoCarta), this.cartasDoDefensor.get(posicaoCarta));
			} else {
				this.defensor.sofrerDanoNoNexus(this.cartasDoAtacante.get(posicaoCarta).getPoderNaBatalha());
				this.atualizarInformacoesCampeaoAtacante(this.cartasDoAtacante.get(posicaoCarta), null);
			}
		}
	}
	
	private void descartarCartas() {
		for (int posicaoCartaDefesa = 0; posicaoCartaDefesa < this.cartasDoDefensor.size(); posicaoCartaDefesa++) {
			if (this.cartasDoDefensor.get(posicaoCartaDefesa).estaDestruida()) {
				this.cartasDoDefensor.remove(posicaoCartaDefesa);
			}
		}
	}
	
	private void finalizarBatalha() {
		this.atacante.ativarEfeitos();
		this.defensor.ativarEfeitos();
		this.descartarCartas();
		this.mesa.imprimir();
		this.atacante.retornarCartasEntreUnidadesEvocadas(this.cartasDoAtacante);
		this.defensor.retornarCartasEntreUnidadesEvocadas(this.cartasDoDefensor);
		this.mesa.imprimir();
	}
	
	public void executar() {
		this.prepararBatalha();
		if (this.atacante.escolherAtacar()) {
			this.cartasDoAtacante = this.atacante.obterCartasParaBatalha(); //turno 3
			this.mesa.imprimir();
			if (this.defensor.escolherDefender()) {
				this.cartasDoDefensor = this.defensor.obterCartasParaDefesa(this.cartasDoAtacante); //turno 4
				this.mesa.imprimir();
				this.realizarAtaque();
				this.finalizarBatalha();
			} else {
				this.atacante.atacarNexus(this.defensor);
			}
		}
	}
	
}
