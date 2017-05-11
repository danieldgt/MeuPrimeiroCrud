package br.com.refeicoescrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenericDAO {
	protected PreparedStatement statement;

	public static Connection connection() {
		try {
			String dbURL = "jdbc:postgresql://localhost:5432/refeicoesBD";
			String username = "postgres";
			String password = "postgres";

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(dbURL, username, password);
			if (con != null) {
				System.out.println("Conectado");
				return con;
			}
			return null;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected PreparedStatement gerarStatement(String sql) throws SQLException {
		PreparedStatement statement;
		statement = connection().prepareStatement(sql);
		return statement;
	}
	
	public static void main(String[] args) {
		connection();
	}
}
