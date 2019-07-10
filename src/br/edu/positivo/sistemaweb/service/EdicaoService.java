package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Edicao;

@Local
public interface EdicaoService {

	public void salvar(Edicao edicao);
	public List<Edicao> listar();
	public void excluir(Edicao edicao);
	public Edicao getByID(Integer idEdicao);
	
}
