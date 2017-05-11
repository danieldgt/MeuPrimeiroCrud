<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>
</head>
<body>
	<form action="ProdutoController" method="post">
		ID: <input type="text" name="idProduto" 
			value="<c:out value="${produto.idProduto}"/>" readonly="readonly" /> <br />
		Nome: <input type="text" name="nomeProduto"
			value="<c:out value="${produto.nomeProduto}"/>" /> <br />
			
		<input type="submit" value="Gravar"/>
	</form>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
	<input type="button" value="VOLTAR" onClick="window.location.href='/refeicoescrud/ProdutoController?action=listar'"/>
</body>
</html>