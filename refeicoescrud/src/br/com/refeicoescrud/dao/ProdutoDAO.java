package br.com.refeicoescrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.refeicoescrud.model.Produto;
import br.com.refeicoescrud.util.GenericDAO;

public class ProdutoDAO extends GenericDAO {
	public void insert(Produto produto) throws SQLException {

		String sql = "INSERT INTO produto (nome_produto) VALUES (?)";
		try {
			statement = connection().prepareStatement(sql);

			statement.setString(1, produto.getNomeProduto());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("\nUm novo 'produto' foi inserido com sucesso!");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void delete(int IdProduto) throws SQLException {
		try {
			statement = connection().prepareStatement("delete from produto where id_produto=?");
			// Parameters start with 1
			statement.setInt(1, IdProduto);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void update(Produto produto) throws SQLException {
		try {
			statement = connection()
					.prepareStatement("update produto set nome_produto=?" 
									   + "where id_produto=?");
			// Parameters start with 1
			statement.setString(1, produto.getNomeProduto());
			statement.setInt(2, produto.getIdProduto());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public List<Produto> getAllProdutos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			statement = connection().prepareStatement("select * from produto");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
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

	public Produto getProdutoById(int idProduto) throws SQLException {
		Produto produto = new Produto();
		try {
			statement = connection().prepareStatement("select * from produto where id_produto=?");
			statement.setInt(1, idProduto);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				produto.setIdProduto(rs.getInt("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return produto;
	}
}
