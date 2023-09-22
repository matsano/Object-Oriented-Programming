package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;
import com.unicamp.mc322.Cartas.UnidadeEvocada;
import com.unicamp.mc322.Jogadores.Jogador;

public class AtaqueNexusAdversario extends Efeito {
	
	private Jogador adversario;
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public AtaqueNexusAdversario() {
		super("Unidade aliada ataca o Nexus adversario");
		tipo = TipoDeEfeito.ATAQUE_NEXUS_ADVERSARIO;
	}
	
	public AtaqueNexusAdversario clonar() {
		return new AtaqueNexusAdversario();
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoAleatoria = aleatorio.nextInt(this.unidadesAliadas.size());
			this.adversario.sofrerDanoNoNexus(this.unidadesAliadas.get(posicaoAleatoria).getPoderNaBatalha());
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
