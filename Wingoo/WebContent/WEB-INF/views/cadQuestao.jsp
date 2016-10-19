<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addQuestao" method="post">
	<label>Dificuldade</label>
	<input type="text" name="dificuldade"><br />
	<label>Enunciado</label>
	<input type="text" name="enunciado"><br />
	<label>Valor</label>
	<input type="number" name="valor"><br />
	<label>Status</label>
	<input type="text" name="status"><br />
	<label>Marcadores</label>
	<input type="text" name="marcadores"><br />
	<label> ALTERNATIVA</label><BR>
	<label>Conteudo</label>
	<input type="text" name="conteudo"><br />
	<label>Correta</label>
	<input type="text" name="correta"><br />
	<input type="submit">
	</form>
</body>
</html>