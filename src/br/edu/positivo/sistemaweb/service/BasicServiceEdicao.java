package br.edu.positivo.sistemaweb.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.entity.Edicao;
import br.edu.positivo.sistemaweb.entity.Perfil;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class BasicServiceEdicao<T>{

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

	public List<Edicao> listar() {
		// TODO Auto-generated method stub
		return null;
		
	}
	

}
