<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido</title>
</head>
<body>
	<form action="PedidoController" method="post">
		Usuário: <select name="idUsuario">
					<c:forEach items="${usuarios}" var="usuario">
					  <option value="${usuario.idUsuario}">${usuario.idUsuario} ${usuario.nome}</option>
					</c:forEach>
				</select>
		Prato: <select  name="idPrato">
					<c:forEach items="${pratos}" var="prato">
					  <option value="${prato.idPrato}">${prato.idPrato} ${prato.nomePrato}</option>
					</c:forEach>
				</select>
		<input type="submit" value="Gravar"/>
	</form>
	<br/>
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
	<input type="button" value="VOLTAR" onClick="window.location.href='/refeicoescrud/PedidoController?action=listar'"/>
</body>
</html>