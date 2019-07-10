package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.positivo.sistemaweb.entity.Perfil;

@Stateless
public class PerfilServiceImpl extends BasicServiceImpl<Perfil> implements PerfilService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listar() {
		Query query = em.createQuery("select f from Perfil f");
		return query.getResultList();
	}

	@Override
	public Perfil getPerfilById(Integer id) {
		return em.find(Perfil.class, id);
	}

}
