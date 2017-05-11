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

import br.com.refeicoescrud.dao.PratoDAO;
import br.com.refeicoescrud.dao.ProdutoDAO;
import br.com.refeicoescrud.model.Prato;
import br.com.refeicoescrud.model.Produto;

/**
 * Servlet implementation class PratoController
 */
@WebServlet("/PratoController")
public class PratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT_OR_EDIT = "/prato.jsp";
	private static String LIST_PRATOS = "/listarPratos.jsp";
	private PratoDAO pratoDAO;
	private ProdutoDAO produtoDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PratoController() {
        super();
        pratoDAO = new PratoDAO();
        produtoDAO = new ProdutoDAO();
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
			forward = LIST_PRATOS;
			int idPrato = Integer.parseInt(request.getParameter("pratoID"));
			try {
				pratoDAO.delete(idPrato);
				request.setAttribute("pratos", pratoDAO.getAllPratos());
			} catch (SQLException e) {
			
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("editar")) {
			// lógica de negócio para editar
			forward = INSERT_OR_EDIT;
			try {
				int id = Integer.parseInt(request.getParameter("pratoID"));
				Prato prato = pratoDAO.getPratoById(id);
				request.setAttribute("prato", prato);
				request.setAttribute("produtos", produtoDAO.getAllProdutos());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("listar")) {
			// lógica de negócio para listar
			forward = LIST_PRATOS;
			try {
				request.setAttribute("pratos", pratoDAO.getAllPratos());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("inserir")) {
			// lógica de negócio para inserir
			forward = INSERT_OR_EDIT;
			try {
				request.setAttribute("produtos", produtoDAO.getAllProdutos());
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
		// TODO Auto-generated method stub
		Prato prato = new Prato();

		prato.setNomePrato(request.getParameter("nomePrato"));
		prato.setDescricao(request.getParameter("descricao"));
		prato.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		try {
			List<Produto> prodList = produtoDAO.getAllProdutos();
			List<Produto> prodContidos = new ArrayList<Produto>();
			for (Produto produto : prodList) {
				if(request.getParameter("produto_"+produto.getIdProduto())!=null){
					prodContidos.add(produto);
				}
			}
			prato.setProdutosContidos(prodContidos);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String id = request.getParameter("idPrato");
		try {
			if (id == null || id.isEmpty()) {
				pratoDAO.insert(prato);
			} else {
				prato.setIdPrato(Integer.parseInt(id));
				pratoDAO.update(prato);
			}
			
			request.setAttribute("pratos", pratoDAO.getAllPratos());
			RequestDispatcher view = request.getRequestDispatcher(LIST_PRATOS);
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
