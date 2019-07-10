package br.edu.positivo.sistemaweb.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanDetalhe")
@SessionScoped
public class MbeanDetalhe {

	@EJB
	ClienteService clienteService;

	private Carta carta;
	
	public String carregar(Carta carta) {
		this.carta = carta;
		return "detalhe.jsf";
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

}
