package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;



@Local
public interface BasicService<T extends Object> {

	public void salvar(T type);
	public List<T> listar();
	public void excluir(T type);
	public <T>T buscarPorChave(Class<T> type, Object object);
	
}
