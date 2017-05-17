package br.com.hellojpa.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

import br.com.hellojpa.dao.UsuarioDAO;
import br.com.hellojpa.model.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;
	private Usuario usuario;

	public UsuarioBean() {
		usuarioDAO = new UsuarioDAO();
		usuario = new Usuario();
		setUsuarios(usuarioDAO.getList());
	}

	public void saveUsuario() {
		usuarioDAO.salvar(usuario);
		setUsuarios(usuarioDAO.getList());
		usuario = new Usuario();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful", "Your message: " + "teste"));
		context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		
		System.out.println(context);

	}

	public void removeUsuario() {
		usuarioDAO.remover(usuario.getId());
		setUsuarios(usuarioDAO.getList());
	}

	public void editUsuario() {
		usuario = usuarioDAO.encontrar(usuario.getId());
	}

	public void novoUsuario() {
		usuario = new Usuario();
	}

	public void limpar() {
		usuario = new Usuario();
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
}
