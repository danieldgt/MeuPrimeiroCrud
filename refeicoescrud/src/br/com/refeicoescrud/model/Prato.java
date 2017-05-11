package br.com.refeicoescrud.model;

import java.util.List;

public class Prato {
	private int idPrato;
	private String descricao;
	private String nomePrato;
	private Double preco;
	private List<Produto> produtosContidos;
	
	public int getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<Produto> getProdutosContidos() {
		return produtosContidos;
	}
	public void setProdutosContidos(List<Produto> produtosContidos) {
		this.produtosContidos = produtosContidos;
	}
	@Override
	public String toString() {
		return "Prato [ids = " 
				+ idPrato + "], nome = [ " 
				+ nomePrato + "]";
	}
	
}
