package br.com.akira.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.model.bean.Usuario;
import br.com.akira.model.dao.UsuarioDAO;

@WebServlet(value = "/usuController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// pega o paramamentro da tela
		String id = request.getParameter("id");
		
		String acao = request.getParameter("acao");
		if (acao == null) {
			acao = "listar";
		}

		// lista Usuarios em uma tabela na jsp
		if (acao.equals("listar")) {
			// Pega o Metodo de buscar Todos Usuarios
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.buscaTodos();

			request.setAttribute("lista", lista);
			request.getRequestDispatcher("WEB-INF/usuarioLista.jsp").forward(request, response);
		}

		// Encaminha para pagina de cadastrar
		else if (acao.equals("Cadastrar")) {
			request.getRequestDispatcher("WEB-INF/usuarioCadastrar.jsp").forward(request, response);
		}

		// Editar - busca por ID e preenche o formulario de cadastro
		else if (acao.equals("Editar")) {

			// busca por Id
			UsuarioDAO dao = new UsuarioDAO();
			Usuario objBuscado = dao.buscaPorId(Integer.parseInt(id));

			// Atribui o Obj buscado
			request.setAttribute("objBuscado", objBuscado);
			request.getRequestDispatcher("WEB-INF/usuarioEditar.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// A pagina de usuarioCadastrar.jsp chama pela method POST
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel = request.getParameter("nivel");

		// chama o usuario
		Usuario u = new Usuario();
		if (id != null)
			u.setId(Integer.parseInt(id));
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		if (nivel != null)
			u.setNivel(Integer.parseInt(nivel));

		// Cadastra com DAO
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);

		response.sendRedirect("usuController");

	}

}
