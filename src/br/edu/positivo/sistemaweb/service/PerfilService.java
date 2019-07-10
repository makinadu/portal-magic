package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Perfil;

@Local
public interface PerfilService {
	
	public List<Perfil> listar();
	public Perfil getPerfilById(Integer id);

}
