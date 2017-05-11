<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prato</title>
</head>
<body>
	<form action="PratoController" method="post">
		ID: <input type="text" name="idPrato" 
			value="<c:out value="${prato.idPrato}"/>" readonly="readonly" /> <br />
		Nome: <input type="text" name="nomePrato"
			value="<c:out value="${prato.nomePrato}"/>" /> <br />
		Descrição: <input type="text" name="descricao"
			value="<c:out value="${prato.descricao}"/>" /> <br />
		Preço: <input type="text" name="preco"
			value="<c:out value="${prato.preco}"/>" /> <br />	
		<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome Produto</th>
				<th>Presente</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><c:out value="${produto.idProduto}" /></td>
					<td><c:out value="${produto.nomeProduto}" /></td>
					<c:set var="contains" value="false" />
					<c:forEach items="${prato.produtosContidos}" var="prodC">
					  <c:if test="${produto.idProduto eq prodC.idProduto}">
					    <c:set var="contains" value="true" />
					  </c:if>
					</c:forEach>
					<td>
						<c:if test="${contains eq 'true'}">
					    	<input type="checkbox" name="produto_${produto.idProduto}" checked="checked"><br>
					  	</c:if>
					  	<c:if test="${contains eq 'false'}">
					    	<input type="checkbox" name="produto_${produto.idProduto}"><br>
					  	</c:if>
					</td> 
				</tr>
			</c:forEach>
		</tbody>
		</table>	
			
			
		<input type="submit" value="Gravar"/>
	</form>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
	<input type="button" value="VOLTAR" onClick="window.location.href='/refeicoescrud/PratoController?action=listar'"/>
</body>
</html>