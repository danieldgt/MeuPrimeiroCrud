package br.com.refeicoescrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import br.com.refeicoescrud.model.Pedido;
import br.com.refeicoescrud.util.GenericDAO;

public class PedidoDAO extends GenericDAO {
	private PratoDAO pratoDAO;
	private UsuarioDAO usuarioDAO;
	
	public PedidoDAO(){
		pratoDAO = new PratoDAO();
		usuarioDAO = new UsuarioDAO();
	}
	
	public void insert(Pedido pedido) throws SQLException {

		String sql = "INSERT INTO pedido (id_prato, id_usuario, data_hora) VALUES (?,?,NOW())";
		try {
			
			statement = connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(pedido.getPrato() != null){
				statement.setInt(1, pedido.getPrato().getIdPrato());
			}else{
				statement.setInt(1, pedido.getIdPrato());
			}
			
			if(pedido.getUsuario() != null){
				statement.setInt(2, pedido.getUsuario().getIdUsuario());
			}else{
				statement.setInt(2, pedido.getIdUsuario());
			}
			
			int rowsInserted = statement.executeUpdate();
						
			if (rowsInserted > 0) {
				System.out.println("\n Um novo 'prato' foi inserido com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void delete(Pedido pedido) throws SQLException {
		try {
			statement = connection().prepareStatement("delete from pedido where id_prato=? AND id_usuario=? AND data_hora=?");
			// Parameters start with 1
			if(pedido.getPrato() != null){
				statement.setInt(1, pedido.getPrato().getIdPrato());
			}else{
				statement.setInt(1, pedido.getIdPrato());
			}
			
			if(pedido.getUsuario() != null){
				statement.setInt(2, pedido.getUsuario().getIdUsuario());
			}else{
				statement.setInt(2, pedido.getIdUsuario());
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date data = format.parse(pedido.getDataHora());
			
			statement.setTimestamp(3, java.sql.Timestamp.valueOf(pedido.getDataHora()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}
	}

	
	public List<Pedido> getAllPedido() throws SQLException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			statement = connection().prepareStatement("select * from pedido");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPrato(rs.getInt("id_prato"));
				pedido.setIdUsuario(rs.getInt("id_usuario"));
				pedido.setDataHora(rs.getString("data_hora"));
				pedido.setPrato(pratoDAO.getPratoById(pedido.getIdPrato()));
				pedido.setUsuario(usuarioDAO.getUsuarioById(pedido.getIdUsuario()));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!statement.isClosed()) {
				statement.close();
			}
		}

		return pedidos;
	}

}

