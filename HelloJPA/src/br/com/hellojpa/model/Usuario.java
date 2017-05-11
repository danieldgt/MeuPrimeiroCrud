package br.com.hellojpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pojo Usuário
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "login")
	private String login;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nick")
	private String nick;

	@Column(name = "info_usuario")
	private String infoUSuario;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getInfoUSuario() {
		return infoUSuario;
	}

	public void setInfoUSuario(String infoUSuario) {
		this.infoUSuario = infoUSuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
