package br.edu.positivo.sistemaweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.entity.Item;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanCarrinho")
@SessionScoped
public class MBeanCarrinho {

	private List<Item> itens = new ArrayList<Item>();
	
	public String adicionar(Cliente cliente) {
		Item item = new Item();
		item.setQuantidade(1);
		item.setCliente(cliente);
		itens.add(item);
		return "/protegido/carrinho.jsf?faces-redirect=true";
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
