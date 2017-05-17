package br.com.hellojpa.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.hellojpa.dao.ProdutoDAO;
import br.com.hellojpa.model.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {
	
	private ProdutoDAO produtoDAO;
	private List<Produto> produtos;
	private Produto produto;
		
	private String INSERT_EDIT = "produto";
	private String LIST_REMOVE = "listarProdutos";
	
	public ProdutoBean() {
		produtoDAO = new ProdutoDAO();
		setProduto(new Produto());
		setProdutos(produtoDAO.getList());
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
	
	public String saveProduto(){
		produtoDAO.salvar(produto);
		setProdutos(produtoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String removeProduto(String uid){
		produtoDAO.remover(Long.parseLong(uid));
		setProdutos(produtoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String editProduto(String uid){
		produto = produtoDAO.encontrar(Long.parseLong(uid));
		return INSERT_EDIT;
	}
	
	public String novoProduto(){
		produto = new Produto();
		return INSERT_EDIT;
	}
}