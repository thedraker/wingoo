<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Alternativa</title>
</head>
<body>
	<form action="addAlternativa" method="post">
	<label>Conteudo</label>
	<input type="text" name="conteudo"><br />
	<label>Correta</label>
	<input type="text" name="correta"><br />
	<label>ID da Questão</label>
	<input type="text" name="idQuestao" value="${questao.idQuestao}" readonly><br />
	<input type="submit">
	</form>
</body>
</html>