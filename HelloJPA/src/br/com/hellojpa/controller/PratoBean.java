package br.com.hellojpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.hellojpa.dao.PratoDAO;
import br.com.hellojpa.dao.ProdutoDAO;
import br.com.hellojpa.model.Prato;
import br.com.hellojpa.model.Produto;

@ManagedBean
@SessionScoped
public class PratoBean {
	
	private PratoDAO pratoDAO;
	private List<Prato> pratos;
	private Prato prato;
	private ProdutoDAO produtoDAO;
	
	private List<Produto> allProdutos;
	private List<String> selectedProdutos;
		
	private String INSERT_EDIT = "prato";
	private String LIST_REMOVE = "listarPratos";
	
	public PratoBean() {
		pratoDAO = new PratoDAO();
		produtoDAO = new ProdutoDAO();
		setPrato(new Prato());
		setPratos(pratoDAO.getList());
		setAllProdutos(produtoDAO.getList());
		setSelectedProdutos(new ArrayList<String>());
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}	

	public List<Produto> getAllProdutos() {
		return allProdutos;
	}

	public void setAllProdutos(List<Produto> allProdutos) {
		this.allProdutos = allProdutos;
	}
	
	public String savePrato(){
		System.out.println("Vai salvar o prato");
		prato.getProdutos().clear();
		for (Produto pi : allProdutos) {
			for (Object pj : selectedProdutos) {
				if(pj.toString().equals(pi.toString())){
					prato.getProdutos().add(pi);
				}
			}
		}
		pratoDAO.salvar(prato);
		
		setPratos(pratoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String removePrato(String uid){
		pratoDAO.remover(Long.parseLong(uid));
		setPratos(pratoDAO.getList());
		return LIST_REMOVE;
	}
	
	public String editPrato(String uid){
		prato = pratoDAO.encontrar(Long.parseLong(uid));
		setAllProdutos(produtoDAO.getList());
		selectedProdutos.clear();
		for (Produto produto : prato.getProdutos()) {
			selectedProdutos.add(produto.toString());
		}
		return INSERT_EDIT;
	}
	
	public String novoPrato(){
		prato = new Prato();
		prato.setProdutos(new ArrayList<Produto>());
		setAllProdutos(produtoDAO.getList());
		selectedProdutos.clear();
		return INSERT_EDIT;
	}
	
	public List<String> getSelectedProdutos() {
		return selectedProdutos;
	}

	public void setSelectedProdutos(List<String> selectedProdutos) {
		this.selectedProdutos = selectedProdutos;
	}



}