package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import br.edu.positivo.sistemaweb.entity.Edicao;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class EdicaoServiceImpl extends BasicServiceImpl<Edicao> implements EdicaoService {


	@SuppressWarnings("unchecked")
	@Override
	public List<Edicao> listar() {
		Query query = em.createQuery("select e from Edicao e");
		return query.getResultList();
	}

	@Override
	public Edicao getByID(Integer id) {
		return em.find(Edicao.class, id);
	}
	
}
