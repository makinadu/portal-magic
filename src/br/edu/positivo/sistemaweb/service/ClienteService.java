package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Cliente;

@Local
public interface ClienteService {

	public void salvar(Cliente cliente);
	public List<Cliente> listar();
	public void excluir(Cliente cliente);
	public Cliente validar(Cliente cliente) throws Exception;
	
}
