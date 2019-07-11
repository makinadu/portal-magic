package br.edu.positivo.sistemaweb.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
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

	@EJB
	CarrinhoService carrinhoService;
	
	private Carrinho carrinho = new Carrinho();
	
	private ItemCarrinho item = new ItemCarrinho();
	
	private List<ItemCarrinho> itens = new ArrayList<>();
	

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

	public ItemCarrinho getItem() {
		return item;
	}

	public void setItem(ItemCarrinho item) {
		this.item = item;
	}
	
	public void valueChangeListener(ValueChangeEvent e){
		item.setQuantidade(new Integer(e.getNewValue().toString()));
		System.out.println("Quantidade: " + item.getQuantidade());
	}
	
	public String adicionar(Carta carta) {
		
		ExternalContext externalContext = FacesContext.
				getCurrentInstance().getExternalContext();
		Cliente cliente = (Cliente) ((HttpServletRequest)externalContext.getRequest()).
			getSession().getAttribute("cliente");
		
		item.setCarta(carta);
		carrinho.setCliente(cliente);
		carrinhoService.adicionarItem(carrinho, item);
		return "/protegido/carrinho.jsf?faces-redirect=true";
	}


	
}
