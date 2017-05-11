package br.com.refeicoescrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.refeicoescrud.model.Prato;
import br.com.refeicoescrud.model.Produto;
import br.com.refeicoescrud.util.GenericDAO;

public class PratoDAO extends GenericDAO {
	private ContemDAO contemDAO;
	
	public PratoDAO(){
		contemDAO = new ContemDAO();
	}
	
	public void insert(Prato prato) throws SQLException {

		String sql = "INSERT INTO prato (nome_prato,descricao,preco) VALUES (?,?,?)";
		try {
			
			statement = connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, prato.getNomePrato());
			statement.setString(2, prato.getDescricao());
			statement.setDouble(3, prato.getPreco());
			
			int rowsInserted = statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				int idPrato = rs.getInt("id_prato");
				prato.setIdPrato(idPrato);
			}
			
			if (rowsInserted > 0) {
				System.out.println("\n Um novo 'prato' foi inserido com sucesso!");
				for (Produto produto : prato.getProdutosContidos()) {
					contemDAO.insert(prato.getIdPrato(), produto.getIdProduto());
				}
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
			contemDAO.delete(idPrato);
			statement = connection().prepareStatement("delete from prato where id_prato=?");
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

	public void update(Prato prato) throws SQLException {
		try {
			statement = connection()
					.prepareStatement("update prato set nome_prato=?,descricao=?,preco=?" 
									   + "where id_prato=?");
			// Parameters start with 1
			statement.setString(1, prato.getNomePrato());
			statement.setString(2, prato.getDescricao());
			statement.setDouble(3, prato.getPreco());
			statement.setInt(4, prato.getIdPrato());
			statement.executeUpdate();

			contemDAO.delete(prato.getIdPrato());
			for (Produto produto : prato.getProdutosContidos()) {
				contemDAO.insert(prato.getIdPrato(), produto.getIdProduto());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public List<Prato> getAllPratos() throws SQLException {
		List<Prato> pratos = new ArrayList<Prato>();
		try {
			statement = connection().prepareStatement("select * from prato");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Prato prato = new Prato();
				prato.setIdPrato(rs.getInt("id_prato"));
				prato.setNomePrato(rs.getString("nome_prato"));
				prato.setDescricao(rs.getString("descricao"));
				prato.setPreco(rs.getDouble("preco"));
				prato.setProdutosContidos(contemDAO.getAllProdutosFromPrato(prato.getIdPrato()));
				pratos.add(prato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return pratos;
	}

	public Prato getPratoById(int idprato) throws SQLException {
		Prato prato = new Prato();
		try {
			statement = connection().prepareStatement("select * from prato where id_prato=?");
			statement.setInt(1, idprato);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				prato.setIdPrato(rs.getInt("id_prato"));
				prato.setNomePrato(rs.getString("nome_prato"));
				prato.setDescricao(rs.getString("descricao"));
				prato.setPreco(rs.getDouble("preco"));
				prato.setProdutosContidos(contemDAO.getAllProdutosFromPrato(prato.getIdPrato()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return prato;
	}
}
