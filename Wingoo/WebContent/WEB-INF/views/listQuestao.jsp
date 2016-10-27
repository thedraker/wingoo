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
		<th>Dificuldade</th>
		<th>Enunciado</th>
		<th>Valor</th>
		<th>Marcadores</th>
		<th>Status</th>
		<th>Disciplina</th>
		<th>Gerenciar</th>
	</tr>
	<c:forEach items="${questao}" var="questao">
	<tr>
	<td>${questao.idQuestao}</td>
	<td>${questao.dificuldade}</td>
	<td>${questao.enunciado}</td>
	<td>${questao.valor}</td>
	<td>${questao.marcadores}</td>
	<td>${questao.status}</td>
	<td>${questao.disciplina.nomeDisciplina}</td>
	<td><a href="linkAlterQuestao?idQuestao=${turma.idQuestao}">Alterar</a></td>
	<td><a href="desativarQuestao?idQuestao=${questao.idQuestao}">Desativar</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>