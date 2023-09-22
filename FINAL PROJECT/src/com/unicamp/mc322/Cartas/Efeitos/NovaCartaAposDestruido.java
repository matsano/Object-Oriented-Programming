package com.unicamp.mc322.Cartas.Efeitos;

import com.unicamp.mc322.Jogadores.*;
import com.unicamp.mc322.Cartas.UnidadeEvocada;

public class NovaCartaAposDestruido extends Efeito {
	
	private Jogador jogador;
	
	public NovaCartaAposDestruido() {
		super("Ganha nova carta após ser destruido");
		tipo = TipoDeEfeito.NOVA_CARTA_APOS_DESTRUIDA;
	}
	
	public NovaCartaAposDestruido clonar() {
		return new NovaCartaAposDestruido();
	}
	
	public void ativar() {
		if (!this.ativado) {
			UnidadeEvocada dona = (UnidadeEvocada) this.dona;
			if (dona.estaDestruida()) {
				this.jogador.obterCartaDoTopoDoDeck();
			}
			this.ativado = true;
		}
	}
	
	public void atualizarJogador(Jogador umJogador) {
		this.jogador = umJogador;
	}

}
