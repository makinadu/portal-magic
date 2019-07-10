package br.edu.positivo.sistemaweb.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.edu.positivo.sistemaweb.entity.Carrinho;
import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.entity.ItemCarrinho;
import br.edu.positivo.sistemaweb.service.CarrinhoService;


@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanCarrinho")
@SessionScoped
public class MBeanCarrinho {

    @Inject
    private HttpServletRequest request;
	
	@EJB
	CarrinhoService carrinhoService;
	
	private Carrinho carrinho = new Carrinho();
	
	private List<ItemCarrinho> itens = new ArrayList<>();
	
	public String adicionar(Carta carta, Integer quantidade) {
		
		ItemCarrinho item = new ItemCarrinho();
		item.setQuantidade(quantidade);
		item.setCarta(carta);
		
		carrinho.setCliente((Cliente) request.getSession().getAttribute("cliente"));
		
		carrinhoService.adicionarItem(carrinho, item);
		
		return "/protegido/carrinho.jsf?faces-redirect=true";
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}


}
