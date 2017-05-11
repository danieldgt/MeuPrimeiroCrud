package br.com.refeicoescrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.refeicoescrud.model.Usuario;
import br.com.refeicoescrud.util.GenericDAO;

public class UsuarioDAO extends GenericDAO {

	public void insert(Usuario usuario) throws SQLException {

		String sql = "INSERT INTO usuario (nome, login ,email) VALUES (?, ?, ?)";
		try {
			statement = connection().prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getEmail());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("\nUma novo 'usuario' foi inserida com sucesso!");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void delete(int IdUsuario) throws SQLException {
		try {
			statement = connection().prepareStatement("delete from usuario where id_usuario=?");
			// Parameters start with 1
			statement.setInt(1, IdUsuario);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void update(Usuario usuario) throws SQLException {
		try {
			statement = connection()
					.prepareStatement("update usuario set nome=?, email=?, login=?" + "where id_usuario=?");
			// Parameters start with 1
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getLogin());
			statement.setInt(4, usuario.getIdUsuario());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public List<Usuario> getAllUsuarios() throws SQLException {
		List<Usuario> users = new ArrayList<Usuario>();
		try {
			statement = connection().prepareStatement("select * from usuario");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				users.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return users;
	}

	public Usuario getUsuarioById(int idUsuario) throws SQLException {
		Usuario usuario = new Usuario();
		try {
			statement = connection().prepareStatement("select * from usuario where id_usuario=?");
			statement.setInt(1, idUsuario);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return usuario;
	}

}
