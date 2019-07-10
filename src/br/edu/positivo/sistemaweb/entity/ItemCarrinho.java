package br.edu.positivo.sistemaweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_COMPRA_ITEM")
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "CARTA_ID")
	private Carta carta;
	
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "COMPRA_ID")
	private Carrinho compra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Carrinho getCompra() {
		return compra;
	}

	public void setCarrinho(Carrinho compra) {
		this.compra = compra;
	}
	
	
}
