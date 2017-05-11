package br.com.refeicoescrud.model;

public class Pedido {
	private int idPrato;
	private int idUsuario;
	private String dataHora;
	private Usuario usuario;
	private Prato prato;
	
	public int getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	
	
}
