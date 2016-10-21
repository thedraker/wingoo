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
	<form action="addNovaDisciplina" method="post">
		<div id="otherType" style="display:none;">
<input type="text" name="nomeDisciplina" placeholder="Digite outra disciplina"/>
<input type="submit">
</div>
</form>
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
			<label for="db">Disciplina</label>
<select name="idDisciplina" id="dbType" required>
   <option>Selecione...</option>
   <c:forEach items="${disciplina}" var="disciplina">
   <option value="${disciplina.idDisciplina}">${disciplina.nomeDisciplina}</option>
   </c:forEach>
   <option value="other">Outro</option>
</select>

	<input type="submit">
	</form>
<script src="assets/plugins/jquery/jquery-2.1.3.min.js"></script>
<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="assets/js/outro.js"></script>
</body>
</html>