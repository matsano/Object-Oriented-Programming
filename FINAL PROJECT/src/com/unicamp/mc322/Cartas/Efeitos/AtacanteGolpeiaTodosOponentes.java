package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;

import com.unicamp.mc322.Cartas.UnidadeEvocada;
import com.unicamp.mc322.Jogadores.Jogador;

public class AtacanteGolpeiaTodosOponentes extends Efeito {
	
	private Jogador adversario;
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public AtacanteGolpeiaTodosOponentes() {
		super("Um aliado golpeia todos os oponentes defensores");
		tipo = TipoDeEfeito.ATACANTE_GOLPEIA_TODOS_OPONENTES;
	}
	
	public AtacanteGolpeiaTodosOponentes clonar() {
		return new AtacanteGolpeiaTodosOponentes();
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoUnidadeAliada = aleatorio.nextInt(this.unidadesAliadas.size());
			this.adversario.defenderDeAtaques(this.unidadesAliadas.get(posicaoUnidadeAliada));
			this.ativado = true;
		}
	}
	
	public void atualizarAdversario(Jogador jogador) {
		this.adversario = jogador;
	}
	
	public void atualizarUnidadesAliadas(ArrayList<UnidadeEvocada> unidades) {
		this.unidadesAliadas = unidades;
	}
}
