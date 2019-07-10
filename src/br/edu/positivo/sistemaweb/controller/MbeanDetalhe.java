package br.edu.positivo.sistemaweb.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanDetalhe")
@SessionScoped
public class MbeanDetalhe {

	@EJB
	ClienteService clienteService;

	private Cliente cliente;
	
	public String carregar(Cliente cliente) {
		this.cliente = cliente;
		return "detalhe.jsf";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
