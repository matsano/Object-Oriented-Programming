package com.unicamp.mc322.lab05;

import java.util.*;
import java.time.*;

public class Runner {
	
	public static void main(String[] args) {
		
		LocalDateTime dataEvento1 = LocalDateTime.of(2021, 05, 9, 00, 00);
		LocalDateTime dataEvento2 = LocalDateTime.of(2021, 05, 01, 23, 00);
		LocalDateTime dataReuniao1 = LocalDateTime.of(2002, 05, 12, 17, 43);
		LocalDateTime dataReuniao2 = LocalDateTime.of(2021, 04, 27, 19, 00);
		
		LocalDateTime data1 = LocalDateTime.of(2021, 04, 20, 0, 0);
		LocalDateTime data2 = LocalDateTime.of(2021, 05, 7, 0, 0);
		
		Agenda agenda = new Agenda();
		
		LembreteDiaSemana lembrete1 = new LembreteDiaSemana("Entrega de lab MC322", Calendar.SUNDAY);
		LembreteMensal lembrete2 = new LembreteMensal("Estudar POO", Calendar.MAY);
		LembreteComum lembrete3 = new LembreteComum("Alimentar o pet");
		Evento evento1 = new Evento("Teste 2 MC322", dataEvento1);
		Evento evento2 = new Evento("Fazer laboratorio", dataEvento2);
		Reuniao reuniao1 = new Reuniao("Aula MC322", dataReuniao1);
		Reuniao reuniao2 = new Reuniao("Duvidas lab05", dataReuniao2);
		
		Participante participante1 = new Participante("Matheus", "m222370@dac.unicamp.br", "01010-1010");
		Participante participante2 = new Participante("Leonardo", "leonardo@ic.unicamp.br", "23232-3232");
		Participante participante3 = new Participante("Gabriel", "g000000@dac.unicamp.br", "45454-5454");
		
		agenda.adicionarLembrete(lembrete1);
		agenda.adicionarLembrete(lembrete2);
		agenda.adicionarLembrete(lembrete3);
		agenda.adicionarLembrete(evento1);
		agenda.adicionarLembrete(evento2);
		agenda.adicionarLembrete(reuniao1);
		agenda.adicionarLembrete(reuniao2);
		agenda.cancelarLembrete(reuniao1);
		
		reuniao2.convidarParticipante(participante1);
		reuniao2.convidarParticipante(participante2);
		reuniao2.convidarParticipante(participante3);
		reuniao2.confirmarParticipante(participante1);
		reuniao2.confirmarParticipante(participante2);
		
		agenda.imprimirLembretesHoje();
		agenda.imprimirLembretes(1, 9, 5, 2021);
		agenda.imprimirLembretesIntervalo(data1, data2);
	}
}
