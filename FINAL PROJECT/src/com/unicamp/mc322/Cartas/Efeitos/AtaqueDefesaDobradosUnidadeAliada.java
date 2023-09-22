package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;

import com.unicamp.mc322.Cartas.UnidadeEvocada;

public class AtaqueDefesaDobradosUnidadeAliada extends Efeito {
	
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public AtaqueDefesaDobradosUnidadeAliada() {
		super("Ataque e defesa dobrados para uma unidade aliada");
		tipo = TipoDeEfeito.ATAQUE_DEFESA_DOBRADO;
	}
	
	public AtaqueDefesaDobradosUnidadeAliada clonar() {
		return new AtaqueDefesaDobradosUnidadeAliada();
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoAleatoria = aleatorio.nextInt(this.unidadesAliadas.size());
			this.unidadesAliadas.get(posicaoAleatoria).dobrarVidaPoder();
			this.ativado = true;
		}
	}
	
	public void atualizarUnidadesAliadas(ArrayList<UnidadeEvocada> unidades) {
		this.unidadesAliadas = unidades;
	}
}
