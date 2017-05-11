package br.com.refeicoescrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.refeicoescrud.model.Produto;
import br.com.refeicoescrud.util.GenericDAO;

public class ContemDAO extends GenericDAO {
	
	public void insert(int idPrato, int idProduto) throws SQLException {

		String sql = "INSERT INTO contem (id_prato, id_produto) VALUES (?, ?)";
		try {
			statement = connection().prepareStatement(sql);

			statement.setInt(1, idPrato);
			statement.setInt(2, idProduto);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("\n Um novo 'contem' foi inserida com sucesso!");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}
	
	public void delete(int idPrato) throws SQLException {
		try {
			statement = connection().prepareStatement("delete from contem where id_prato=?");
			// Parameters start with 1
			statement.setInt(1, idPrato);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}
	
	public void delete(int idPrato, int idProduto) throws SQLException {
		try {
			statement = connection().prepareStatement("delete from contem where id_prato=? AND id_produto=?");
			// Parameters start with 1
			statement.setInt(1, idPrato);
			statement.setInt(2, idProduto);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}


	public List<Produto> getAllProdutosFromPrato(int idPrato) throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			statement = connection().prepareStatement("select * from contem NATURAL JOIN produto where id_prato = ?");
			statement.setInt(1, idPrato);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setDescricao(rs.getString("nome_produto"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return produtos;
	}
}
