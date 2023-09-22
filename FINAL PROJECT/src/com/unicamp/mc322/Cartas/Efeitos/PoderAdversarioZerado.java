package com.unicamp.mc322.Cartas.Efeitos;

import com.unicamp.mc322.Jogadores.Jogador;

public class PoderAdversarioZerado extends Efeito {
	
	private Jogador adversario;
	
	public PoderAdversarioZerado() {
		super("Poder de uma unidade adversaria zerada");
		tipo = TipoDeEfeito.PODER_ADVERSARIO_ZERADO;
	}
	
	public PoderAdversarioZerado clonar() {
		return new PoderAdversarioZerado();
	}
	
	public void ativar() {
		if (!this.ativado) {
			this.adversario.zerarPoderNaBatalha();
			this.ativado = true;
		}
	}
	
	public void atualizarAdversario(Jogador jogador) {
		this.adversario = jogador;
	}
}
