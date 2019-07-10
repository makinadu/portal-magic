package br.edu.positivo.sistemaweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanIndex")
@RequestScoped
public class MbeanIndex {
	
	@EJB
	ClienteService clienteService;
	
	private List<Cliente> clientes;
	
	@PostConstruct
	public void listar() {
		clientes = clienteService.listar();
	}	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
