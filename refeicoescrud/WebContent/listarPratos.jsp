<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Pratos</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Produtos</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pratos}" var="prato">
				<tr>
					<td><c:out value="${prato.idPrato}" /></td>
					<td><c:out value="${prato.nomePrato}" /></td>
					<td><c:out value="${prato.descricao}" /></td>
					<td><c:out value="${prato.preco}" /></td>
					<td>
						<table>
							<c:forEach items="${prato.produtosContidos}" var="produto">
								<tr>
							    	<td><c:out value="${produto.idProduto}" /></td>
									<td><c:out value="${produto.nomeProduto}" /></td>
							    </tr>
						    </c:forEach>
						</table>
					
					</td>
					<td><a href="PratoController?action=editar&pratoID=<c:out value="${prato.idPrato}"/>"> Editar</a></td>
					<td><a href="PratoController?action=deletar&pratoID=<c:out value="${prato.idPrato}"/>"> Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p><a href="PratoController?action=inserir"> Add Prato</a>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
</body>
</html>