<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered">
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Token</th>
		<th>Status</th>
		<th colspan="2">Gerenciar</th>
	</tr>
	<c:forEach items="${turma}" var="turma">
	<tr>
	<td>${turma.idTurma}</td>
	<td>${turma.nome}</td>
	<td>${turma.token}</td>
	<td>${turma.status}</td>
	<td><a href="linkAlterTurma?idTurma=${turma.idTurma}">Alterar</a></td>
	<td><a href="desativarTurma?idTurma=${turma.idTurma}">Desativar</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>