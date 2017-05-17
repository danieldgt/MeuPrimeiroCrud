package br.com.hellojpa.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.hellojpa.dao.UsuarioDAO;
import br.com.hellojpa.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;
	private Usuario usuario;
		
	private String INSERT_EDIT = "usuario";
	private String LIST_REMOVE = "listarUsuarios";
	
	public UsuarioBean() {
		usuarioDAO = new UsuarioDAO();
		usuario = new Usuario();
		setUsuarios(usuarioDAO.getList());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String saveUsuario(){
		usuarioDAO.salvar(usuario);
		setUsuarios(usuarioDAO.getList());
		return LIST_REMOVE;
	}
	
	public String removeUsuario(String uid){
		usuarioDAO.remover(Long.parseLong(uid));
		setUsuarios(usuarioDAO.getList());
		return LIST_REMOVE;
	}
	
	public String editUsuario(String uid){
		usuario = usuarioDAO.encontrar(Long.parseLong(uid));
		return INSERT_EDIT;
	}
	
	public String novoUsuario(){
		usuario = new Usuario();
		return INSERT_EDIT;
	}
}