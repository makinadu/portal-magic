package br.edu.positivo.sistemaweb.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class BasicServiceImpl<T extends Object> implements BasicService<T>{

	@PersistenceContext(unitName = "sistemaweb")
	protected EntityManager em;
	
	@TransactionScoped
	public void salvar(T object) {
		em.merge(object);
	}
	
	@TransactionScoped
	public void excluir(T object) {
		em.remove(em.merge(object));
	}

	public List<T> listar(){
		return null;
	}
	
	@SuppressWarnings("hiding")
	@Override
	public <T> T buscarPorChave(Class<T> type, Object object) {
		return em.find(type, object);
	}
}
