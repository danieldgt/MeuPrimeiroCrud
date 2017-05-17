package br.com.hellojpa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.hellojpa.dao.PedidoDAO;
import br.com.hellojpa.dao.PratoDAO;
import br.com.hellojpa.dao.UsuarioDAO;
import br.com.hellojpa.model.Pedido;
import br.com.hellojpa.model.Prato;
import br.com.hellojpa.model.Usuario;

@ManagedBean
@SessionScoped
public class PedidoBean {

	private PedidoDAO pedidoDAO;
	private Pedido pedido;
	private List<Pedido> pedidos;
	
	private UsuarioDAO usuarioDAO;
	private List<Usuario> allUsuarios;
	private String selectedUsuario;
	
	private PratoDAO pratoDAO;
	
	private List<Prato> allPratos;
	private String selectedPrato;
		
	private String INSERT_EDIT = "pedido";
	private String LIST_REMOVE = "listarPedidos";
	
	public PedidoBean() {
		pedidoDAO = new PedidoDAO();
		pratoDAO = new PratoDAO();
		usuarioDAO = new UsuarioDAO();
		setPedido(new Pedido());
		setPedidos(pedidoDAO.getList());
		setSelectedUsuario(new String());
		setAllUsuarios(usuarioDAO.getList());
		setAllPratos(pratoDAO.getList());
		setSelectedPrato(new String());
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public List<Prato> getAllPratos() {
		return allPratos;
	}

	public void setAllPratos(List<Prato> allPratos) {
		this.allPratos = allPratos;
	}

	public String getSelectedPrato() {
		return selectedPrato;
	}

	public void setSelectedPrato(String selectedPrato) {
		this.selectedPrato = selectedPrato;
	}
	
	public String savePedido(){
		System.out.println("Vai salvar o pedido");
		System.out.println(selectedUsuario);
		System.out.println(selectedPrato);
		pedido.setUsuario(usuarioDAO.encontrar(Long.parseLong(selectedUsuario)));
		List<Prato> pratos = new ArrayList<Prato>();
		pratos.add(pratoDAO.encontrar(Long.parseLong(selectedPrato)));
		pedido.setPratos(pratos);
		pedido.setDtCriacao(new Date());
		pedidoDAO.salvar(pedido);
		setPedidos(pedidoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String removePedido(String uid){
		pedidoDAO.remover(Long.parseLong(uid));
		setPedidos(pedidoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String novoPedido(){
		pedido = new Pedido();
		return INSERT_EDIT;
	}

	public List<Usuario> getAllUsuarios() {
		return allUsuarios;
	}

	public void setAllUsuarios(List<Usuario> allUsuarios) {
		this.allUsuarios = allUsuarios;
	}

	public String getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(String selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

}