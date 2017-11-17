package br.com.akira.controller.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.akira.model.bean.Usuario;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = "/*")
public class UsuarioFilter implements Filter {

	public UsuarioFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();

		// cria uma session e seta um usuario
		HttpSession sessao = req.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		// System.out.println("USuario + " + usuario);

		// só deixa passar se for login.jps ou controlAcesso ou tiver um usuario
		if (uri.lastIndexOf("login.jsp") != -1 || uri.lastIndexOf("controlAcesso") != -1 || usuario != null) {
			chain.doFilter(request, response);
			// System.out.println("Chain..");
		} else {
			req.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
