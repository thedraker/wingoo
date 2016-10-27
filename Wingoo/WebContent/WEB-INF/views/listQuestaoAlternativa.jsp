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
		<th>Id da Questão</th>
		<th>Enunciado da Questão</th>
		<th>Conteudo da Questão</th>
		<th>Correta?</th>
	</tr>
	<c:forEach items="${qa}" var="qa">
	<tr>
	<td>${qa.idQuestaoAlternativa}</td>
	<td>${qa.questao.idQuestao}</td>
	<td>${qa.questao.enunciado}</td>
	<td>${qa.alternativa.conteudo}</td>
	<td>${qa.alternativa.correta}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>