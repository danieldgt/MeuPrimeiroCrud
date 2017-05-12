package br.com.hellojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.com.hellojpa.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Serializable> {

	public List<Produto> getProdutosIDMaiorQue(long idProduto) {
		Query q = entityManager.createQuery("SELECT p FROM Produto p WHERE id > :id_produto");
		q.setParameter("id_produto", idProduto);
		List<Produto> resultList = (List<Produto>) q.getResultList();
		return resultList;
	}
}
