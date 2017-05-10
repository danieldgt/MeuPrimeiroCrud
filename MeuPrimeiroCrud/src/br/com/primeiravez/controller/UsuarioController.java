package br.com.primeiravez.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.primeiravez.bean.Usuario;
import br.com.primeiravez.dao.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSERT_OR_EDIT = "/usuario.jsp";
	private static String LIST_USUARIO = "/listarUsuarios.jsp";
	private UsuarioDAO usuarioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// inicializar os objetos DAO
		usuarioDAO = new UsuarioDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			forward = deletarUsuario(request);

		} else if (action.equalsIgnoreCase("editar")) {
			// lógica de negócio para editar
			forward = INSERT_OR_EDIT;
			try {
				int id = Integer.parseInt(request.getParameter("usuarioID"));
				Usuario usuario = usuarioDAO.getUsuarioById(id);
				request.setAttribute("usuario", usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String idUsuarioString = request.getParameter("usuarioID");

		} else if (action.equalsIgnoreCase("listar")) {
			// lógica de negócio para listar
			forward = LIST_USUARIO;
			try {
				request.setAttribute("usuarios", usuarioDAO.getAllUsuarios());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equalsIgnoreCase("inserir")) {
			// lógica de negócio para inserir
			forward = INSERT_OR_EDIT;
		}

		// fazer os redirecionamentos da minha lógica de negócio
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	private String deletarUsuario(HttpServletRequest request) {
		// lógica de negócio para excluir
		String forward;
		forward = LIST_USUARIO;
		int idUsuario = Integer.parseInt(request.getParameter("usuarioID"));
		try {
			usuarioDAO.delete(idUsuario);
			request.setAttribute("usuarios", usuarioDAO.getAllUsuarios());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forward;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setLogin(request.getParameter("login"));

		String id = request.getParameter("idUsuario");
		try {
			if (id == null || id.isEmpty()) {
				usuarioDAO.insert(usuario);
			} else {
				usuario.setIdUsuario(Integer.parseInt(id));
				usuarioDAO.update(usuario);
			}
			// fazer os redirecionamentos da minha lógica de negócio
			request.setAttribute("usuarios", usuarioDAO.getAllUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(LIST_USUARIO);
			view.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
