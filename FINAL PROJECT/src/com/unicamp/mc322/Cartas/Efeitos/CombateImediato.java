package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;

import com.unicamp.mc322.Cartas.UnidadeEvocada;
import com.unicamp.mc322.Jogadores.Jogador;

public class CombateImediato extends Efeito {
	
	private Jogador adversario;
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public CombateImediato() {
		super("Um aliado e um oponente fazem combate imediato");
		tipo = TipoDeEfeito.COMBATE_IMEDIATO;
	}
	
	public CombateImediato clonar() {
		return new CombateImediato();
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoUnidadeAliada = aleatorio.nextInt(this.unidadesAliadas.size());
			this.adversario.defenderDeCombateImediato(this.unidadesAliadas.get(posicaoUnidadeAliada));
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
