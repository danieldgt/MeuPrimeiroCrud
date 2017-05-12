package br.com.hellojpa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * GenericDAO
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
public abstract class GenericDAO<E, I extends Serializable> extends ProdutorEntityManager {

	protected EntityManager entityManager;

	private Class<E> persistedClass;


    protected GenericDAO(Class<E> persistedClass) {
        this.persistedClass = persistedClass;
        entityManager = createEntityManager();
    }
	
    protected GenericDAO() {
    	final ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.persistedClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
        entityManager = createEntityManager();
    }

	public E salvar(E entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public E atualizar(E entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public void remover(I id) {
		E entity = encontrar(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		E mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

	public List<E> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	public E encontrar(I id) {
		return entityManager.find(persistedClass, id);
	}
}