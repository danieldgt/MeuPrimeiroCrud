package br.com.hellojpa.util;

import java.util.ArrayList;
import java.util.List;

import br.com.hellojpa.dao.PedidoDAO;
import br.com.hellojpa.dao.PratoDAO;
import br.com.hellojpa.dao.ProdutoDAO;
import br.com.hellojpa.dao.UsuarioDAO;
import br.com.hellojpa.model.Pedido;
import br.com.hellojpa.model.Prato;
import br.com.hellojpa.model.Produto;
import br.com.hellojpa.model.Usuario;

public class HelloJPA {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*
		 * System.out .println(PersistenceProviderResolverHolder.
		 * getPersistenceProviderResolver().getPersistenceProviders());
		 * 
		 * EntityManagerFactory factory =
		 * Persistence.createEntityManagerFactory("testehibernate5");
		 * EntityManager manager = factory.createEntityManager();
		 * 
		 * Session session = manager.unwrap(Session.class); Stream<Usuario>
		 * stream = session.createQuery("select a from Usuario a").stream();
		 * 
		 * stream.forEach(u -> System.out.println(u.getNome()));
		 * 
		 * manager.close(); factory.close();
		 */

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setNome("Joazinho");
		usuarioDAO.salvar(usuario);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.getProdutosIDMaiorQue(10);
		List<Produto> produtos2 = produtoDAO.getProdutosIDMaiorQue(25);

		PratoDAO pratoDAO = new PratoDAO();
		Prato prato = new Prato();
		prato.setProdutos(produtos);
		pratoDAO.salvar(prato);

		Prato prato2 = new Prato();
		prato2.setProdutos(produtos2);

		pratoDAO.salvar(prato);
		pratoDAO.salvar(prato2);
		
		List<Prato> pedidosPrato = new ArrayList<>();
		pedidosPrato.add(prato);
		pedidosPrato.add(prato2);
		//List<Prato> pedidosPrato = new ArrayList<Prato>();
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = new Pedido();
		pedido.setUsuario(usuario);
		pedido.setPratos(pedidosPrato);
		pedidoDAO.salvar(pedido);

	}
}