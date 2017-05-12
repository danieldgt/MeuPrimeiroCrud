package br.com.hellojpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pojo pedido
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido", nullable = false)
	private Long id;

	@Column(name = "ds_pedido")
	private String dsPedido;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "pedido_has_prato", joinColumns = { @JoinColumn(name = "id_pedido") }, inverseJoinColumns = {
			@JoinColumn(name = "id_usuario") })
	private List<Prato> pratos;

	@Column(name = "dt_criacao")
	@Temporal(TemporalType.DATE)
	Date dtCriacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsPedido() {
		return dsPedido;
	}

	public void setDsPedido(String dsPedido) {
		this.dsPedido = dsPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

}
