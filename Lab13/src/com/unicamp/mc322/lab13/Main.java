package com.unicamp.mc322.lab13;

import com.unicamp.mc322.lab13.Pedidos.*;
import com.unicamp.mc322.lab13.Estrategias.*;
import com.unicamp.mc322.lab13.EstruturaDeDados.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
    	ICrazyDS crazyDS = new EstruturaDeDadosCustomizada(new PriorityScore());
        //ICrazyDS crazyDS = new EstruturaDeDadosCustomizada(new PrioridadeMediaAritmeticaPonderada());
    	try {
	    	IOrder pedido1 = new PedidoDoLocalFisico(new Pessoa(LocalDate.of( 1985 , Month.JANUARY , 1 ), "111.111.111/34", "nome1"));        
	        crazyDS.adicionarElemento(pedido1);
    	} catch (CpfInvalidoException e) {
    		e.printStackTrace();
    	}
    	try {
    		IOrder pedido2 = new PedidoDoLocalFisico(new Pessoa(LocalDate.of( 1986 , Month.JANUARY , 2 ), "CPF2", "nome2"));
    		crazyDS.adicionarElemento(pedido2);
    	} catch (CpfInvalidoException e) {
    		e.printStackTrace();
    	}
    	try {
    		IOrder pedido3 = new PedidoDaInternet(new Pessoa(LocalDate.of( 1987 , Month.JANUARY , 3 ), "999.878.576/35", "nome3"));
    		crazyDS.adicionarElemento(pedido3);    		
    	} catch (CpfInvalidoException e) {
    		e.printStackTrace();
    	}
    	
    	try {
	        System.out.println("---- A: Elements ----");
	        crazyDS.imprimirElementos();
    	} catch (EstruturaDeDadosException e) {
    		e.printStackTrace();
    	}

       System.out.println("---- B: Getting and removing the element with highest priority ----");
        IOrder p1;
        try {
            p1 = crazyDS.obterElementoDeMaiorPrioridade();
            System.out.println("-selected element");
            p1.imprimirInformacaoReduziaDoCliente();
            crazyDS.removerElemento(p1);
            System.out.println("-elements");
            crazyDS.imprimirElementos();
        } catch (EstruturaDeDadosException e) {
            e.printStackTrace();
        }

        System.out.println("---- C: Adding an old person ----");
        try {
	        IOrder order4 = new PedidoDaInternet(new Pessoa(LocalDate.of( 1880 , Month.JUNE , 1 ), "222.333.444/3", "name3"));
	        crazyDS.adicionarElemento(order4);
	        crazyDS.imprimirElementos();
	        
        } catch (CpfInvalidoException e) {
        	e.printStackTrace();
        } catch (EstruturaDeDadosException e) {
        	e.printStackTrace();
        }
        
        try {
	        System.out.println("-selected element");
	        IOrder p2 = crazyDS.obterElementoDeMaiorPrioridade();
	        p2.imprimirInformacaoCompletaDoCliente();
        } catch (EstruturaDeDadosException e) {
	    	e.printStackTrace();
	    }

       System.out.println("---- D: Checking an exception ----");
        try {
            IOrder p3 = crazyDS.obterElemento(1000);
        } catch (EstruturaDeDadosException e) {
            e.printStackTrace();
        }
    }
}