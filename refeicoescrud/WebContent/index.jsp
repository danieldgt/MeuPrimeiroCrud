<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Refeições</title>
</head>
<body>	
	<form action="index" method="get">
		
		<input type="button" value="Usuario" onClick="window.location.href='/refeicoescrud/UsuarioController?action=listar'"/>
		<input type="button" value="Produtos" onClick="window.location.href='/refeicoescrud/ProdutoController?action=listar'"/>
		<input type="button" value="Pratos" onClick="window.location.href='/refeicoescrud/PratoController?action=listar'"/>
		<input type="button" value="Pedidos" onClick="window.location.href='/refeicoescrud/PedidoController?action=listar'"/>
	</form>
</body>
</html>