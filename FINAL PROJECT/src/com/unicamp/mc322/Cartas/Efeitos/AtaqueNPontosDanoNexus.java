package com.unicamp.mc322.Cartas.Efeitos;

import com.unicamp.mc322.Jogadores.Jogador;

public class AtaqueNPontosDanoNexus extends Efeito {
	
	private Jogador adversario;
	private int pontosDano;
	
	public AtaqueNPontosDanoNexus(int dano) {
		super("Golpeia o Nexus do adversario para " + dano + " pontos dano");
		pontosDano = dano;
		tipo = TipoDeEfeito.ATAQUE_N_DANO_NEXUS;
	}
	
	public AtaqueNPontosDanoNexus clonar() {
		return new AtaqueNPontosDanoNexus(this.pontosDano);
	}
	
	public void ativar() {
		if (!this.ativado) {
			this.adversario.sofrerDanoNoNexus(pontosDano);
			this.ativado = true;
		}
	}
	
	public void atualizarAdversario(Jogador jogador) {
		this.adversario = jogador;
	}
}
