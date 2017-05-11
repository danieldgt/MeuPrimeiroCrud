<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<form action="UsuarioController" method="post">
		ID: <input type="text" name="idUsuario" 
			value="<c:out value="${usuario.idUsuario}"/>" readonly="readonly" /> <br />
		Nome: <input type="text" name="nome"
			value="<c:out value="${usuario.nome}"/>" /> <br />
		Login: <input type="text" name="login"
			value="<c:out value="${usuario.login}"/>" /> <br />
		Email: <input type="text" name="email"
			value="<c:out value="${usuario.email}"/>" /> <br />
			
		<input type="submit" value="Gravar"/>
	</form>
	<br />
	<input type="button" value="HOME" onClick="window.location.href='/refeicoescrud/'"/>
	<input type="button" value="VOLTAR" onClick="window.location.href='/refeicoescrud/UsuarioController?action=listar'"/>
</body>
</html>