package br.com.hellojpa.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.hellojpa.dao.UsuarioDAO;
import br.com.hellojpa.model.Usuario;

@ManagedBean
@SessionScoped
public class HelloBean {


	public HelloBean() {
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario = new Usuario();
//		usuario = usuarioDAO.encontrar(14);
		usuario.setNome("joao");
	}

	
	private Usuario usuario;

	private String name;

	private String nomeUsuario;

	public String getNomeUsuario() {
		nomeUsuario = usuario.getNome();
		return nomeUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}