package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.Usuario.*;

public class AplicativoPidao {
	
	public void usarAplicativo() {
	
		Pidao pidao = new Pidao();
	
		Cliente cliente1 = new Cliente("Matheus", "111.222.333-44", -23.55, -46.64);
		Cliente cliente2 = new Cliente("Leonardo", "555.666.777-88", -20.02, -34.87);
		
		Entregador entregador1 = new Entregador("Guilherme", "345.764.879-19");
		Entregador entregador2 = new Entregador("Camila", "867.735.021-45");
		Entregador entregador3 = new Entregador("Danilo", "565.454.343-5");
		
		Restaurante restaurante1 = new Restaurante("Ponto do Lanchao", "50.647.987/0201-23", -21.34, -45.02);
		Restaurante restaurante2 = new Restaurante("Maramber", "23.456.173/3046-31", 40.34, 23.57);
		
		Lanche cuscuz = new Lanche("CCZ00", "Cuscuz com ovo", 10.00);	
		Lanche macaxeira = new Lanche("MXCOS", "Macaxeira com costela no bafo", 15.00);
		Lanche coxinhaFrango = new Lanche("CXFRA", "Coxinha de frango", 8.00);
		Lanche paoDeQueijo = new Lanche("PADQJ", "Pao de queijo", 4.00);
		Lanche spaghetti = new Lanche("SPPOM", "Spaghetti al pomodoro", 32.50);
	
		restaurante1.adicionarAoCardapio(cuscuz);
		restaurante1.adicionarAoCardapio(macaxeira);
		restaurante1.adicionarAoCardapio(spaghetti);
		restaurante1.removerDoCardapio(macaxeira);
		restaurante2.adicionarAoCardapio(paoDeQueijo);
		restaurante2.adicionarAoCardapio(spaghetti);
		restaurante2.adicionarAoCardapio(coxinhaFrango);
		restaurante2.adicionarAoCardapio(macaxeira);
		restaurante2.adicionarAoCardapio(cuscuz);
		
		restaurante1.contratarEntregador(entregador2);
		restaurante2.contratarEntregador(entregador1);
		restaurante2.contratarEntregador(entregador3);
		
		pidao.cadastrarRestaurante(restaurante1);
		pidao.cadastrarRestaurante(restaurante2);
		pidao.cadastrarUsuario(cliente1);
		pidao.cadastrarUsuario(cliente2);
		pidao.cadastrarUsuario(entregador1);
		pidao.cadastrarUsuario(entregador2);
		pidao.cadastrarUsuario(entregador3);
		
		restaurante2.aplicarDesconto(paoDeQueijo, 25, TipoDesconto.PORCENTAGEM);
		restaurante1.aplicarDesconto(cuscuz, 20, TipoDesconto.PORCENTAGEM);
		restaurante2.aplicarDesconto(spaghetti, 10, TipoDesconto.FIXO);
		restaurante2.removerDesconto(paoDeQueijo);
		
		Pedido pedido1 = new Pedido(cliente1, restaurante2, TipoDeEnvio.RETIRADA);
		pedido1.adicionarLanche(spaghetti);
		pedido1.adicionarLanche(cuscuz);
		pedido1.adicionarLanche(coxinhaFrango);
		pedido1.removerLanche(cuscuz);
		pidao.concluirPedido(pedido1);
		pidao.entregarPedido(pedido1);
		pidao.atualizarPedido(pedido1);
		pidao.entregarPedido(pedido1);
		
		pidao.avaliarRestaurante(pedido1, 4, "Restaurante atencioso com o cliente, porem o troco veio errado.");
		pidao.avaliarLanche(pedido1, spaghetti, 3);
		pidao.avaliarLanche(pedido1, coxinhaFrango, 5, "Coxinha muito boa! Recomendo!");
		pidao.avaliarEntregador(pedido1, 5);
		
		Pedido pedido2 = new Pedido(cliente1, restaurante2, TipoDeEnvio.ENTREGA);
		pedido2.adicionarLanche(macaxeira);
		pedido2.adicionarLanche(paoDeQueijo);
		pidao.concluirPedido(pedido2);
		pidao.cancelarPedido(pedido2);
		
		pidao.avaliarRestaurante(pedido2, 3);
		pidao.avaliarEntregador(pedido2, 3, "Entregador um pouco grosseiro");
		
		Pedido pedido3 = new Pedido(cliente1, restaurante2, TipoDeEnvio.ENTREGA);
		pedido3.adicionarLanche(macaxeira);
		pedido3.adicionarLanche(paoDeQueijo);
		pedido3.adicionarLanche(spaghetti);
		pidao.concluirPedido(pedido3);
		pidao.entregarPedido(pedido3);
		pidao.atualizarPedido(pedido3);
		pidao.entregarPedido(pedido3);
		
		pidao.avaliarRestaurante(pedido3, 3);
		pidao.avaliarLanche(pedido3, macaxeira, 4);
		pidao.avaliarLanche(pedido3, paoDeQueijo, 2, "Pao de queijo frio e duro");
		pidao.avaliarLanche(pedido3, spaghetti, 5, "Muito bom!");
		pidao.avaliarEntregador(pedido3, 5, "Entregador muito educado e chegou rapido");
		
		pidao.imprimir(OpcaoDeImpressao.CARDAPIO);
		pidao.imprimir(OpcaoDeImpressao.PEDIDO);
		pidao.imprimir(OpcaoDeImpressao.AVALIACAO);
	}
}
