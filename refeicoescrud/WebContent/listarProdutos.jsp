<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Produtos</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome Produto</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><c:out value="${produto.idProduto}" /></td>
					<td><c:out value="${produto.nomeProduto}" /></td>
					<td><a href="ProdutoController?action=editar&produtoID=<c:out value="${produto.idProduto}"/>"> Editar</a></td>
					<td><a href="ProdutoController?action=deletar&produtoID=<c:out value="${produto.idProduto}"/>"> Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p><a href="ProdutoController?action=inserir"> Add Produto</a>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
</body>
</html>