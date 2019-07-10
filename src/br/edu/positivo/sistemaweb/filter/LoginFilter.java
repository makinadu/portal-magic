package br.edu.positivo.sistemaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.positivo.sistemaweb.entity.Cliente;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/protegido/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//como eu acesso a sessão?
		Cliente cliente = (Cliente) ((HttpServletRequest)request).
				getSession().getAttribute("cliente");
		if (cliente == null) {
			System.out.println("Não está logado, preciso redirecionar para tela de login");
			((HttpServletResponse)response).sendRedirect("../login.jsf");
			return;
		} 
		//tudo ok
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
