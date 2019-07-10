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
import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Edicao;
import br.edu.positivo.sistemaweb.entity.Perfil;
import br.edu.positivo.sistemaweb.service.CartaService;
import br.edu.positivo.sistemaweb.service.ClienteService;
import br.edu.positivo.sistemaweb.service.EdicaoService;
import br.edu.positivo.sistemaweb.service.PerfilService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanCarta")
@RequestScoped
public class MbeanCarta {

	@EJB
	CartaService cartaService;

	@EJB
	EdicaoService edicaoService;

	private List<Carta> cartas;

	private List<Edicao> edicoes;

	private Integer id;
	private String nome;	
	private Integer idEdicao;
	private Double valor;
	private Part foto;

	
	@PostConstruct
	public void listar() {
		cartas = cartaService.listar();
		edicoes = edicaoService.listar();
	}

	public void salvar() {
		try {
			Edicao edicaoSelecionada = edicaoService.getByID(idEdicao);
			java.lang.String caminhoDaImagem = salvarFoto(foto);

			Carta carta = new Carta();
			carta.setId(id);
			carta.setNome(nome);
			carta.setCaminhoDaImagem(caminhoDaImagem);
			carta.setEdicao(edicaoSelecionada);
			carta.setValor(valor);
			cartaService.salvar(carta);

			id = null;
			nome = null;
			idEdicao = null;
			valor = null;

			listar();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}


	private java.lang.String salvarFoto(Part foto) throws Exception {
		if (foto != null && foto.getSubmittedFileName() != null) {
			byte [] arquivo = new byte [(int) foto.getSize()];
			foto.getInputStream().read(arquivo);
			java.lang.String fileName = SiteConfigs.IMAGE_PATH + foto.getSubmittedFileName();
			File file = new File(fileName);
			FileOutputStream out = new FileOutputStream(file);
			out.write(arquivo);
			out.close();
			return fileName;
		} 
		return null;
	}

	public java.lang.String excluir(Carta carta) {
		cartaService.excluir(carta);
		listar();
		return "";
	}


	public java.lang.String carregar(Carta carta) {
		this.id = carta.getId();
		this.nome = carta.getNome();	
		if(carta.getEdicao() != null) {
			this.idEdicao = carta.getEdicao().getId();
		}

		return "";
	}

	public CartaService getCartaService() {
		return cartaService;
	}

	public void setCartaService(CartaService cartaService) {
		this.cartaService = cartaService;
	}

	public EdicaoService getEdicaoService() {
		return edicaoService;
	}

	public void setEdicaoService(EdicaoService edicaoService) {
		this.edicaoService = edicaoService;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public List<Edicao> getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(List<Edicao> edicoes) {
		this.edicoes = edicoes;
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

	public Integer getIdEdicao() {
		return idEdicao;
	}

	public void setIdEdicao(Integer idEdicao) {
		this.idEdicao = idEdicao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	
}
