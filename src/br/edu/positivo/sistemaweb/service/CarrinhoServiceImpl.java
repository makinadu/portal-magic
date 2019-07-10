package br.edu.positivo.sistemaweb.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.edu.positivo.sistemaweb.entity.Carrinho;
import br.edu.positivo.sistemaweb.entity.ItemCarrinho;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class CarrinhoServiceImpl extends BasicServiceImpl<Object> implements CarrinhoService {

	@Override
	public Carrinho adicionarItem(Carrinho carrinho, ItemCarrinho item) {
		salvar(carrinho);
		
		item.setCarrinho(carrinho);
		item.setValor(calcularSubTotal(item));
		
		salvar(item);

		
		return buscarPorChave(Carrinho.class, carrinho.getId());
	}
	
	private Double calcularSubTotal(ItemCarrinho item) {
		return item.getCarta().getValor() * item.getQuantidade();
	}


	private Double calcularValorTotal(List<ItemCarrinho> items) {
		Double valor = 0d;
		for (ItemCarrinho item : items) {
			valor += calcularSubTotal(item);
		}
		return valor;
	}

	@Override
	public Carrinho finalizarCompra(Carrinho carrinho) {
		
		carrinho.setValor(calcularValorTotal(carrinho.getItems()));
		carrinho.setDataFinalizacao(new Date());
		
		salvar(carrinho);
		
		return carrinho;
	}
	
}
