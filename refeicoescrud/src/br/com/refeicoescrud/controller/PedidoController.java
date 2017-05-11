package br.com.refeicoescrud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.refeicoescrud.dao.PedidoDAO;
import br.com.refeicoescrud.dao.PratoDAO;
import br.com.refeicoescrud.dao.UsuarioDAO;
import br.com.refeicoescrud.model.Pedido;
import br.com.refeicoescrud.model.Prato;
import br.com.refeicoescrud.model.Produto;

/**
 * Servlet implementation class PratoController
 */
@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT_OR_EDIT = "/pedido.jsp";
	private static String LIST_PEDIDOS = "/listarPedidos.jsp";
	private PedidoDAO pedidoDAO;
	private PratoDAO pratoDAO;
	private UsuarioDAO usuarioDAO;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoController() {
        super();
        pedidoDAO = new PedidoDAO();
        pratoDAO = new PratoDAO();
        usuarioDAO = new UsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			forward = LIST_PEDIDOS;
			Pedido pedido = new Pedido();
			pedido.setDataHora( request.getParameter("dataHora"));
			pedido.setIdPrato(Integer.parseInt(request.getParameter("pratoID")));
			pedido.setIdUsuario(Integer.parseInt(request.getParameter("usuarioID")));
			try {
				pedidoDAO.delete(pedido);
				request.setAttribute("pedidos", pedidoDAO.getAllPedido());
			} catch (SQLException e) {
			
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("editar")) {
			// lógica de negócio para editar
			forward = INSERT_OR_EDIT;
			/*try {
				int id = Integer.parseInt(request.getParameter("pratoID"));
				Prato prato = pratoDAO.getPratoById(id);
				request.setAttribute("prato", prato);
				request.setAttribute("produtos", produtoDAO.getAllProdutos());
			} catch (SQLException e) {
				e.printStackTrace();
			}*/

		} else if (action.equalsIgnoreCase("listar")) {
			// lógica de negócio para listar
			forward = LIST_PEDIDOS;
			try {
				request.setAttribute("pedidos", pedidoDAO.getAllPedido());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("inserir")) {
			// lógica de negócio para inserir
			forward = INSERT_OR_EDIT;
			try {
				request.setAttribute("pratos", pratoDAO.getAllPratos());
				request.setAttribute("usuarios", usuarioDAO.getAllUsuarios());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();

		pedido.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
		pedido.setIdPrato(Integer.parseInt(request.getParameter("idPrato")));
				
		try {
			
			pedidoDAO.insert(pedido);
						
			request.setAttribute("pedidos", pedidoDAO.getAllPedido());
			RequestDispatcher view = request.getRequestDispatcher(LIST_PEDIDOS);
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
