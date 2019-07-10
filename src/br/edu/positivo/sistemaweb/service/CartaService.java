package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Edicao;

@Local
public interface CartaService {

	public void salvar(Carta carta);
	public List<Carta> listar();
	public List<Carta> listarPorEdicao(Edicao edicao);
	public void excluir(Carta carta);
	
}
