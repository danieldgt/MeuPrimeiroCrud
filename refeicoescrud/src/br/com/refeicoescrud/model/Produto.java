package br.com.refeicoescrud.model;

public class Produto {
	private int idProduto;
	private String nomeProduto;
		
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Override
	public String toString() {
		return "Produto [ids = " 
				+ idProduto + "], nome = [ " 
				+ nomeProduto + "]";
	}
}
