package br.com.hellojpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * ProdutorEntityManager
 * 
 * @author Daniel Alencar Barros Tavares
 * @version 1.0
 * @since 11/05/2017
 */
public class ProdutorEntityManager {
	private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	/**
	 * Criar EntityManagerFactory único e para todas as chamadas
	 */
	public static EntityManagerFactory getEmf() {
		if (factory == null || !factory.isOpen()) {
			try {
				factory = Persistence.createEntityManagerFactory("testehibernate5");
			} catch (RuntimeException ex) {
				System.out.println("não foi possível carregar a unidade de persistencia");
				throw ex;
			}
		}
		return factory;
	}

	/**
	 * Cria um entity manager único (se criar = true) para a thread e o retorna
	 * em todas as demais chamadas
	 */
	public static EntityManager em(boolean criar) {
		EntityManager em = (EntityManager) threadLocal.get();
		if (em == null || !em.isOpen()) {
			if (criar) {
				em = getEmf().createEntityManager();
				threadLocal.set(em);
			}
		}
		return em;
	}

	/**
	 * Cria um entity manager único para a thread e o retorna em todas as demais
	 * chamadas
	 */
	public static EntityManager createEntityManager() {
		return em(true);
	}

}
