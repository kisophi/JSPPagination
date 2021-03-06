package br.com.akira.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.akira.jdbc.util.ConnectionFactory;
import br.com.akira.model.bean.Usuario;

public class UsuarioDAO {

	Connection conn = ConnectionFactory.getConnection();

	// Cadastro de Usuario
	public void cadastrar(Usuario u) {
		String sql = "INSERT INTO usuario VALUES(null,?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.execute();
			System.out.println("CADASTRAR : " + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Editar Usuario
	public void editar(Usuario u) {
		String sql = "UPDATE usuario SET nome=?, login=?, senha=?, nivel=? WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.setInt(5, u.getId());
			ps.execute();
			System.out.println("EDITAR : " + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Salvar
	public void salvar(Usuario u) {
		if (u.getId() == 0) {
			cadastrar(u);
		} else {
			editar(u);
		}
	}

	// exclui Usuario
	public void excluir(int id) {
		String sql = "DELETE FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
			System.out.println("DELETE : " + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// busca por Id
	public Usuario buscaPorId(int id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// valida o acesso do Usuario
	public Usuario validaAcesso(String login, String senha) {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Busca Todos os Usuarios
	public List<Usuario> buscaTodos() {
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Busca Todos os Usuarios
	public List<Usuario> buscaPorNome(String nome) {
		String sql = "SELECT * FROM usuario WHERE nome like ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Conta qts registros tem na tabela
	public int qtdRegistro(String buscarPor,String like) {
		String sql = "SELECT COUNT(*)as qtdRegistros FROM usuario WHERE "+buscarPor+" like ?" ;
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%"+like+"%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int total = rs.getInt("qtdRegistros");
				return total;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Usuario> listaCompleta(String buscarPor, String like, String orderBy, int limit, int offset) {
		String sql = "SELECT * FROM usuario WHERE " + buscarPor + " LIKE ? ORDER BY "+orderBy+" ASC LIMIT ? OFFSET ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%"+like+"%");
			ps.setInt(2, limit);
			ps.setInt(3, offset);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			System.out.println("SELECT "+ps.toString());
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
