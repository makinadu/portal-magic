package br.edu.positivo.sistemaweb.service;


import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Carrinho;
import br.edu.positivo.sistemaweb.entity.ItemCarrinho;

@Local
public interface CarrinhoService {

	public Carrinho adicionarItem(Carrinho carrinho, ItemCarrinho item);
	
	public Carrinho finalizarCompra(Carrinho carrinho);//	
	
}
