package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Edicao;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class CartaServiceImpl extends BasicService<Carta> implements CartaService{


	@SuppressWarnings("unchecked")
	@Override
	public List<Carta> listar() {
		return em.createQuery("select c from Carta c")
				.getResultList();
	}

	@Override
	public List<Carta> listarPorEdicao(Edicao edicao) {
		return em.createQuery("select c from Carta c WHERE c.edicao = :edicao")
				.setParameter("edicao", edicao)
				.getResultList();
	}



	
}
