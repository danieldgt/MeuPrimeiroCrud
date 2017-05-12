package br.com.hellojpa.model;

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

/**
 * Pojo prato
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
@Entity
@Table(name = "prato")
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prato", nullable = false)
	private Long id;

	@Column(name = "ds_prato")
	private String dsPrato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "prato_has_produto", joinColumns = { @JoinColumn(name = "id_prato") }, inverseJoinColumns = {
			@JoinColumn(name = "id_produto") })
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsPrato() {
		return dsPrato;
	}

	public void setDsPrato(String dsPrato) {
		this.dsPrato = dsPrato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
