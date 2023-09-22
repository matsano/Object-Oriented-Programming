package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;

import com.unicamp.mc322.Cartas.UnidadeEvocada;

public class VidaCuradaUmaUnidadeAliada extends Efeito {
	
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public VidaCuradaUmaUnidadeAliada() {
		super("Cura totalmente uma unidade aliada");
		tipo = TipoDeEfeito.VIDA_TOTALMENTE_CURADA;
	}
	
	public VidaCuradaUmaUnidadeAliada clonar() {
		return new VidaCuradaUmaUnidadeAliada();
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoAleatoria = aleatorio.nextInt(this.unidadesAliadas.size());
			this.unidadesAliadas.get(posicaoAleatoria).curarInteiramente();
			this.ativado = true;
		}
	}
	
	public void atualizarUnidadesAliadas(ArrayList<UnidadeEvocada> unidades) {
		this.unidadesAliadas = unidades;
	}
}
