<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Pedidos</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID Usuário</th>
				<th>Nome Usuário</th>
				<th>ID Prato</th>
				<th>Nome Prato</th>
				<th>Data/Hora</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td><c:out value="${pedido.usuario.idUsuario}" /></td>
					<td><c:out value="${pedido.usuario.nome}" /></td>
					<td><c:out value="${pedido.prato.idPrato}" /></td>
					<td><c:out value="${pedido.prato.nomePrato}" /></td>
					<td><c:out value="${pedido.dataHora}" /></td>
					<td><a href="PedidoController?action=deletar&usuarioID=<c:out value="${pedido.usuario.idUsuario}"/>&pratoID=<c:out value="${pedido.prato.idPrato}"/>&dataHora=<c:out value="${pedido.dataHora}"/>"> Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p><a href="PedidoController?action=inserir"> Add Pedido</a>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
</body>
</html>
