package com.unicamp.mc322.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.unicamp.mc322.Cartas.*;
import com.unicamp.mc322.Cartas.Efeitos.*;
import com.unicamp.mc322.Cartas.Tracos.*;
import com.unicamp.mc322.Cartas.MelhoriasNivelSuperior.*;

public class FactoryDeck {
	
	private ArrayList<Carta> deck = new ArrayList<Carta>();
	private List<Carta> lista;
	
	public Deck getDeck(String nome) {
		
		if(nome.equals("Demacia")) {
			
			Campeao carta1 = new Campeao("Garen", 5, 5, 5, CondicaoSubirNivel.ATACAR_N_VEZES, 2);
			VidaCuradaUmaUnidadeAliada efeito1 = new VidaCuradaUmaUnidadeAliada();
			carta1.adicionarEfeito(efeito1);
			Elusivo elusivo = new Elusivo();
			carta1.adicionarTraco(elusivo);
			PoderAumentado poder1 = new PoderAumentado(carta1, 1);
			VidaAumentada vida1 = new VidaAumentada(carta1, 1);
			
			Seguidor carta2 = new Seguidor("Tiana", 8, 7, 7);
			AtaqueNexusAdversario efeito2 = new AtaqueNexusAdversario();
			carta2.adicionarEfeito(efeito2);
			
			Seguidor carta3 = new Seguidor("Vanguarda", 4, 3, 3);
			PoderVidaTodasUnidadesAliadas efeito3 = new PoderVidaTodasUnidadesAliadas(1, 1);
			carta3.adicionarEfeito(efeito3);
			
			Seguidor carta4 = new Seguidor("Duelista", 3, 3, 2);
			NovaCartaAposDestruido efeito4 = new NovaCartaAposDestruido();
			carta4.adicionarEfeito(efeito4);
			
			Furia furia1 = new Furia(0, 1);
			Seguidor carta5 = new Seguidor("Defensor", 2, 2, 2, furia1);
			
			Seguidor carta6 = new Seguidor("Poro", 1, 2, 1);
			
			Seguidor carta7 = new Seguidor("Poro Defensor", 1, 1, 2);
			NovaCartaAposDestruido efeito5 = new NovaCartaAposDestruido();
			carta7.adicionarEfeito(efeito5);
			
			Feitico carta8 = new Feitico("Julgamento", 8);
			AtacanteGolpeiaTodosOponentes efeito6 = new AtacanteGolpeiaTodosOponentes();
			carta8.adicionarEfeito(efeito6);
			
			Feitico carta9 = new Feitico("Valor Redobrado", 6);
			VidaCuradaUmaUnidadeAliada efeito7 = new VidaCuradaUmaUnidadeAliada();
			AtaqueDefesaDobradosUnidadeAliada efeito8 = new AtaqueDefesaDobradosUnidadeAliada();
			carta9.adicionarEfeito(efeito7);
			carta9.adicionarEfeito(efeito8);
			
			Feitico carta10 = new Feitico("Golpe Certeiro", 1);
			PoderVidaUmaUnidadeAliada efeito9 = new PoderVidaUmaUnidadeAliada(1, 1);
			carta10.adicionarEfeito(efeito9);
			
			Feitico carta11 = new Feitico("Combate um-a-um", 2);
			CombateImediato efeito10 = new CombateImediato();
			carta11.adicionarEfeito(efeito10);
			
			lista = Arrays.asList(carta1, carta2, carta3, carta4, carta5, carta6, 
					carta7, carta8, carta9, carta10, carta11);
			
			deck.addAll(lista);
			return new Demacia(deck);
		}
		
		return null;
	}
	
	public ArrayList<Carta> obterDeck(){
		return this.deck;
	}
}
