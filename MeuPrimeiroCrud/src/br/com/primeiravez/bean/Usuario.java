package br.com.primeiravez.bean;

/**
 * Bean de usuário (essa classe é responsável por definar as características do
 * bean usuário)
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 09/05/2017
 *
 */
public class Usuario {

	private String nome;
	private String login;
	private int idUsuario;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [ids = " 
				+ idUsuario + "], nome = [ " 
				+ nome + "]";
	}
}
