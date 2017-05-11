package br.com.refeicoescrud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.refeicoescrud.dao.ProdutoDAO;
import br.com.refeicoescrud.model.Produto;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String INSERT_OR_EDIT = "/produto.jsp";
	private static String LIST_PRODUTO = "/listarProdutos.jsp";
	private ProdutoDAO produtoDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoController() {
        super();
        
        produtoDAO = new ProdutoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			forward = LIST_PRODUTO;
			int idProduto = Integer.parseInt(request.getParameter("produtoID"));
			try {
				produtoDAO.delete(idProduto);
				request.setAttribute("produtos", produtoDAO.getAllProdutos());
			} catch (SQLException e) {
			
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("editar")) {
			// lógica de negócio para editar
			forward = INSERT_OR_EDIT;
			try {
				int id = Integer.parseInt(request.getParameter("produtoID"));
				Produto produto = produtoDAO.getProdutoById(id);
				request.setAttribute("produto", produto);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("listar")) {
			// lógica de negócio para listar
			forward = LIST_PRODUTO;
			try {
				request.setAttribute("produtos", produtoDAO.getAllProdutos());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("inserir")) {
			// lógica de negócio para inserir
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();

		produto.setNomeProduto(request.getParameter("nomeProduto"));

		String id = request.getParameter("idProduto");
		try {
			if (id == null || id.isEmpty()) {
				produtoDAO.insert(produto);
			} else {
				produto.setIdProduto(Integer.parseInt(id));
				produtoDAO.update(produto);
			}
			
			request.setAttribute("produtos", produtoDAO.getAllProdutos());
			RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUTO);
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
