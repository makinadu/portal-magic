package br.edu.positivo.sistemaweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CARTA")
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;

	private java.lang.String caminhoDaImagem;

	private Double valor;

	@ManyToOne
	@JoinColumn(name = "EDICAO_ID")
	private Edicao edicao;

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

	public java.lang.String getCaminhoDaImagem() {
		return caminhoDaImagem;
	}

	public void setCaminhoDaImagem(java.lang.String caminhoDaImagem2) {
		this.caminhoDaImagem = caminhoDaImagem2;
	}

	public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
