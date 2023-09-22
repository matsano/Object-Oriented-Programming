package com.unicamp.mc322.lab05;

import java.time.*;

public class Evento extends LembreteComum {
	
	private LocalDateTime dataEvento;
	
	public Evento(String mensagem, LocalDateTime data) {
		super(mensagem);
		dataEvento = data;
	}
	
	public boolean podeImprimir(int diaSemana, int dia, int mes, int ano) {
		boolean podeImprimir = false;
		if (this.dataEvento.getDayOfMonth() == dia) {
			if (this.dataEvento.getMonthValue() == mes) {
				if (this.dataEvento.getYear() == ano) {
					podeImprimir = true;
				}
			}
		}
		return podeImprimir;
	}
}
