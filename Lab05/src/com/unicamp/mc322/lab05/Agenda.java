package com.unicamp.mc322.lab05;

import java.util.ArrayList;
import java.time.*;

public class Agenda {
	
	private ArrayList<LembreteComum> lembretes;
	private LocalDateTime diaAtual = LocalDateTime.now();
	
	public Agenda() {
		lembretes = new ArrayList();
	}
	
	public void adicionarLembrete(LembreteComum lembrete) {
		this.lembretes.add(lembrete);
	}
	
	public void cancelarLembrete(LembreteComum lembrete) {
		this.lembretes.remove(lembrete);
	}
	
	public void imprimirLembretes(int diaDaSemana, int dia, int mes, int ano) {
		System.out.println(dia + "/" + mes + "/" + ano);
		for (int numeroLembrete = 0; numeroLembrete < this.lembretes.size(); numeroLembrete++) {
			if (this.lembretes.get(numeroLembrete).podeImprimir(diaDaSemana, dia, mes, ano) == true) {
				this.lembretes.get(numeroLembrete).imprimirLembrete();
			}
		}
	}
	
	public void imprimirLembretesHoje() {
		System.out.print("HOJE ");
		int diaHoje = this.diaAtual.getDayOfMonth();
		int diaDaSemanaHoje = this.diaAtual.getDayOfWeek().getValue();
		int mesHoje = this.diaAtual.getMonthValue();
		int anoHoje = this.diaAtual.getYear();
		imprimirLembretes(diaDaSemanaHoje, diaHoje, mesHoje, anoHoje);
	}
	
	public void imprimirLembretesIntervalo(LocalDateTime limiteInferior, LocalDateTime limiteSuperior) {
		int ano = limiteInferior.getYear();
		int mes = limiteInferior.getMonthValue();
		int dia = limiteInferior.getDayOfMonth();
		int diaDaSemana = limiteInferior.getDayOfWeek().getValue() + 1;
		if (diaDaSemana == 8) {
			diaDaSemana = 1;
		}
		boolean condicao = true;
		
		while (condicao) {
			if (ano < limiteSuperior.getYear()) {
				imprimirLembretes(diaDaSemana, dia, mes, ano);
			} else if (ano == limiteSuperior.getYear()) {
				if (mes < limiteSuperior.getMonthValue()) {
					imprimirLembretes(diaDaSemana, dia, mes, ano);
				} else if (mes == limiteSuperior.getMonthValue()) {
					if (dia <= limiteSuperior.getDayOfMonth()) {
						imprimirLembretes(diaDaSemana, dia, mes, ano);
					} else {
						condicao = false;
					}
				} else {
					condicao = false;
				}
			} else {
				condicao = false;
			}
			if (dia+1 > 31) {
				dia = 1;
				if (mes+1 > 12) {
					mes = 1;
					ano = ano + 1;
				} else {
					mes = mes + 1;
				}
			} else {
				dia = dia + 1;
			}
			if (diaDaSemana+1 > 7) {
				diaDaSemana = 1;
			} else {
				diaDaSemana = diaDaSemana + 1;
			}
		}
	}
}
