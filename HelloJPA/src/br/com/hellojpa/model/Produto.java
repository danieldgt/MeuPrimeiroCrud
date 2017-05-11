package br.com.hellojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pojo Produto
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto", nullable = false)
	private Long id;

	@Column(name = "ds_produto")
	private String dsProduto;

	@Column(name = "obs_produto", columnDefinition = "TEXT")
	private String obsProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public String getObsProduto() {
		return obsProduto;
	}

	public void setObsProduto(String obsProduto) {
		this.obsProduto = obsProduto;
	}

}
