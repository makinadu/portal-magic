package br.edu.positivo.sistemaweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import br.edu.positivo.sistemaweb.config.SiteConfigs;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.entity.Edicao;
import br.edu.positivo.sistemaweb.entity.Perfil;
import br.edu.positivo.sistemaweb.service.ClienteService;
import br.edu.positivo.sistemaweb.service.EdicaoService;
import br.edu.positivo.sistemaweb.service.PerfilService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanEdicao")
@RequestScoped
public class MbeanEdicao {

	@EJB
	EdicaoService service;

	private List<Edicao> edicoes;

	private Integer id;
	private String nome;	


	@PostConstruct
	public void listar() {
		setEdicoes(service.listar());
	}

	public void salvar() {
		try {			

			Edicao edicao = new Edicao();
			edicao.setId(id);
			edicao.setNome(nome);

			service.salvar(edicao);
			resetar();
			listar();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}

	private void resetar() {
		// TODO Auto-generated method stub

	}


	public String excluir(Cliente cliente) {
		//clienteService.excluir(cliente);
		//clientes = clienteService.listar();
		return "";
	}


	public String carregar(Edicao edicao) {
		this.id = edicao.getId();
		this.nome = edicao.getNome();		
		return "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Edicao> getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(List<Edicao> edicoes) {
		this.edicoes = edicoes;
	}

}
