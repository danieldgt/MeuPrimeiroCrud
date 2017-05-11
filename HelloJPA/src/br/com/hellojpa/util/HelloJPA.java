package br.com.hellojpa.util;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.hibernate.Session;

import br.com.hellojpa.model.Usuario;

public class HelloJPA {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out
				.println(PersistenceProviderResolverHolder.getPersistenceProviderResolver().getPersistenceProviders());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("testehibernate5");
		EntityManager manager = factory.createEntityManager();

		Session session = manager.unwrap(Session.class);
		Stream<Usuario> stream = session.createQuery("select a from Usuario a").stream();

		stream.forEach(u -> System.out.println(u.getNome()));

		manager.close();
		factory.close();
	}
}