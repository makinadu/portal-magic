package br.edu.positivo.sistemaweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.positivo.sistemaweb.config.SiteConfigs;
import br.edu.positivo.sistemaweb.entity.Carta;
import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.BasicService;
import br.edu.positivo.sistemaweb.service.BasicServiceImpl;

@WebServlet("/CarregarImagemCarta")
public class CarregarImagemCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/*	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	*/
	@EJB
	private BasicService<Carta> service = new  BasicServiceImpl<>();
	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request != null && request.getParameter("id") != null) {
		
			Integer id = Integer.valueOf(request.getParameter("id"));
			Carta carta = service.buscarPorChave(Carta.class, id);
			String caminhoDaImagem = carta.getCaminhoDaImagem();
			if(caminhoDaImagem == null || caminhoDaImagem.isEmpty()) {
				caminhoDaImagem = SiteConfigs.DEFAULT_IMAGE_PATH;
			}
			
			File file = new File(caminhoDaImagem);
			byte [] conteudoArquivo = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(conteudoArquivo);
			
			response.getOutputStream().write(conteudoArquivo);
			
			fis.close();
			
		} 
		
	}	

}
