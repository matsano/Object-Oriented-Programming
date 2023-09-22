package com.unicamp.mc322.Cartas;

import java.util.ArrayList;
import com.unicamp.mc322.Cartas.Efeitos.*;
import com.unicamp.mc322.Jogadores.*;

public abstract class Carta {
	
	protected String nome;
	protected int custoMana;
	protected ArrayList<Efeito> efeitos;
	
	protected Carta(String umNome, int custo) {
		nome = umNome;
		custoMana = custo;
		efeitos = new ArrayList<Efeito>();
	}
	
	protected abstract void imprimirInformacaoAdicional();
	
	public void adicionarEfeito(Efeito novoEfeito) {
		Efeito efeito = novoEfeito.clonar();
		this.efeitos.add(efeito);
		efeito.determinarDona(this);
	}
	
	public void imprimirInformacaoReduzida() {
		System.out.print(this.nome);
		System.out.print(" (Mana: " + this.custoMana + ")");
	}
	
	public void imprimirInformacaoCompleta() {
		this.imprimirInformacaoReduzida();
		System.out.println();
		this.imprimirInformacaoAdicional();
		System.out.println();
	}
	
	public void imprimirEfeitos() {
		int posicao = 0;
		System.out.println("Efeitos: " + this.efeitos.size());
		while (posicao < this.efeitos.size()) {
			this.efeitos.get(posicao).imprimir();
		}
	}
	
	public boolean temEssaCarta(ArrayList<Carta> cartas) {
		boolean cartaEncontrada = false;
		int posicaoCarta = 0;
		while ((!cartaEncontrada) && (posicaoCarta < cartas.size())) {
			if (cartas.get(posicaoCarta) == this) {
				cartaEncontrada = true;
			}
			posicaoCarta += 1;
		}
		return cartaEncontrada;
	}
	
	private void descartarEfeitos() {
		int posicao = 0;
		while (posicao < this.efeitos.size()) {
			if (this.efeitos.get(posicao).foiAtivado()) {
				this.efeitos.remove(posicao);
			} else {
				posicao += 1;
			}
		}
	}
	
	private void verificarTipoEfeito(Efeito efeito, ArrayList<UnidadeEvocada> unidadesAliadas, Jogador adversario, Jogador donoDaCarta) {
		switch (efeito.getTipo()) {
		case ATAQUE_DEFESA_DOBRADO:
			AtaqueDefesaDobradosUnidadeAliada ataqueDefesaDobrados = (AtaqueDefesaDobradosUnidadeAliada) efeito;
			ataqueDefesaDobrados.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case PODER_VIDA_UNIDADES_ALIADAS:
			PoderVidaTodasUnidadesAliadas poderVidaUnidadesAliadas = (PoderVidaTodasUnidadesAliadas) efeito;
			poderVidaUnidadesAliadas.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case PODER_VIDA_UMA_ALIADA:
			PoderVidaUmaUnidadeAliada poderVidaUmaAliada = (PoderVidaUmaUnidadeAliada) efeito;
			poderVidaUmaAliada.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case VIDA_TOTALMENTE_CURADA:
			VidaCuradaUmaUnidadeAliada vidaTotalmenteCurada = (VidaCuradaUmaUnidadeAliada) efeito;
			vidaTotalmenteCurada.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case ATAQUE_NEXUS_ADVERSARIO:
			AtaqueNexusAdversario ataqueNexus = (AtaqueNexusAdversario) efeito;
			ataqueNexus.atualizarAdversario(adversario);
			ataqueNexus.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case ATAQUE_N_DANO_NEXUS:
			AtaqueNPontosDanoNexus ataqueNPontosNexus = (AtaqueNPontosDanoNexus) efeito;
			ataqueNPontosNexus.atualizarAdversario(adversario);
			break;
		case COMBATE_IMEDIATO:
			CombateImediato combateImediato = (CombateImediato) efeito;
			combateImediato.atualizarAdversario(adversario);
			combateImediato.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case ATACANTE_GOLPEIA_TODOS_OPONENTES:
			AtacanteGolpeiaTodosOponentes golpeTodosOponentes = (AtacanteGolpeiaTodosOponentes) efeito;
			golpeTodosOponentes.atualizarAdversario(adversario);
			golpeTodosOponentes.atualizarUnidadesAliadas(unidadesAliadas);
			break;
		case PODER_ADVERSARIO_ZERADO:
			PoderAdversarioZerado poderAdversarioZerado = (PoderAdversarioZerado) efeito;
			poderAdversarioZerado.atualizarAdversario(adversario);
			break;
		case NOVA_CARTA_APOS_DESTRUIDA:
			NovaCartaAposDestruido novaCarta = (NovaCartaAposDestruido) efeito;
			novaCarta.atualizarJogador(donoDaCarta);
			break;
		}
	}
	
	public void ativarEfeitos(ArrayList<UnidadeEvocada> unidadesAliadas, Jogador adversario, Jogador donoDaCarta) {
		if (this.efeitos != null) {
			for (int posicaoEfeito = 0; posicaoEfeito < this.efeitos.size(); posicaoEfeito++) {
				this.verificarTipoEfeito(this.efeitos.get(posicaoEfeito), unidadesAliadas, adversario, donoDaCarta);
				this.efeitos.get(posicaoEfeito).ativar();
			}
			this.descartarEfeitos();
		}
	}
	
	public int obterDiferencaDoCustoMana(int pontosMana) {
		return pontosMana - this.custoMana;
	}
	
	public int getCustoMana() {
		return this.custoMana;
	}
	
}
