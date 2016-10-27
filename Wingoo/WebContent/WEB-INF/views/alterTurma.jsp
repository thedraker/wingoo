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
	<form action="alteraTurma" method="post">
	<input type="text" name="idTurma" value="${turma.idTurma}"/><br>
	<label>Nome</label>
	<input type="text" name="nome" value="${turma.nome}"><br />
	<label>Token</label>
	<input type="text" name="token" value="${turma.token}"><br />
	<input type="hidden" name="status" value="Vivo"><br />
	<input type="submit">
	</form>
</body>
</html>