package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reuniao extends Evento {
	
	private ArrayList<Participante> participantes;
	
	public Reuniao(String mensagem, LocalDateTime data) {
		super(mensagem, data);
		participantes = new ArrayList();
	}
	
	public void convidarParticipante(Participante participante) {
		this.participantes.add(participante);
	}
	
	private boolean verificarConvidado(Participante participante) {
		boolean estaConvidado = false;
		int numeroParticipante = 0;
		while (estaConvidado == false && numeroParticipante < this.participantes.size()) {
			if (participante == this.participantes.get(numeroParticipante)) {
				estaConvidado = true;
			}
			numeroParticipante ++;
		}
		return estaConvidado;
	}
	
	public void confirmarParticipante(Participante participante) {
		if (verificarConvidado(participante) == true) {
			participante.setConfirmado(true);
		}
	}
	
	public boolean podeImprimir(int diaSemana, int dia, int mes, int ano) {
		return super.podeImprimir(diaSemana, dia, mes, ano);
	}
	
	@Override
	public void imprimirLembrete() {
		System.out.println("Reuniao");
		super.imprimirLembrete();
		System.out.println("  Participantes:");
		for (int numeroParticipante = 0; numeroParticipante < this.participantes.size(); numeroParticipante++) {
			this.participantes.get(numeroParticipante).imprimirParticipante();
			System.out.println();
		}
	}
	
}
