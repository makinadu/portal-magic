package br.edu.positivo.sistemaweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.CartaService;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanIndex")
@RequestScoped
public class MbeanIndex {
	
	@EJB
	CartaService service;
	
	public List<Carta> getCartas() {
		return service.listar();
	}

}
