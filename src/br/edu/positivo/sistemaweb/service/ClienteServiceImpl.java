package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;

import br.edu.positivo.sistemaweb.entity.Cliente;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class ClienteServiceImpl extends BasicServiceImpl<Cliente> implements ClienteService {


	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		return (List<Cliente>)em.createQuery("select c from Cliente c")
				.getResultList();
	}

@Override
public Cliente validar(Cliente cliente) throws Exception {
	try {
		Cliente validated = (Cliente) em
				.createQuery("select c from Cliente c WHERE c.login = :login AND c.senha = :senha")
				.setParameter("login", cliente.getLogin())
				.setParameter("senha", cliente.getSenha())
				.getSingleResult();
		return validated;
	} catch (Exception e) {
		System.out.println("Usuário inexistente ou senha inválida: " + cliente.getLogin() + ".");
		throw new Exception("Falha ao realizar login: "+ e.getMessage() + ".");
	}
}
	
	
}
