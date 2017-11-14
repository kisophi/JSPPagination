package br.com.akira.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.model.bean.Usuario;
import br.com.akira.model.dao.UsuarioDAO;

@WebServlet(value = "/controlAcesso")
public class UsuarioAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioAcesso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Ao chama o doget da classe finaliza a sessao
		//finaliza a Sessao
		HttpSession sessao = request.getSession();
		if(sessao!=null){//se existir
			sessao.invalidate();//invalida
		}
		request.setAttribute("msgFinalizaSessao", "Sessao Finalizada !!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Pega os parametros da tela de login.jsp
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		// Chama o metodo DAO validaAcesso
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioValido = dao.validaAcesso(login, senha);

		if (usuarioValido != null) {
			HttpSession sessao = request.getSession();
			// sessao.setMaxInactiveInterval(60*5);
			sessao.setAttribute("nomeUsuario", usuarioValido.getNome());
			
			// Encaminha para a Pagina de index.jsp
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		} else {
			// segue a sequencia
			// Primeiro chama a msg de acesso invalido
			request.setAttribute("msgAcessoInvalido", "Login/Senha Inválidos");

			// Segundo chama a pagina login.jsp
			// acesso negado volta para pagina de login.jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
