<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Alternativa</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						// valor mínimo de campos cadastrados
						var min_fields = 4;
						// Campos máximos que podem ser criados (valor alto)
						var max_fields = 1000;
						// Classe de input fields do formulário
						var wrapper = $(".input_fields_wrap"); //Fields wrapper
						// Classe de submit do formulário
						var wrapperSubmit = $(".wrapperSubmit"); //Fields wrapper
						// Variável de adicionar um botão
						var add_button = $(".add_field_button"); //Add button ID
						// Variável de enviar
						var enviar = $(".enviar");
						// Valor inicial de contador de cada texto adicionado 
						var x = 2;
						// Ao clicar em adicionar uma alternativa, faça esta ação
						$(add_button)
								.click(
										function(e) {
											e.preventDefault();
											var length = wrapper
													.find("input:text").length;
											// Caso ainda não haja tantas alternativas quanto o valor máximo permitido (1000), adicione.
											if (x < max_fields) { //max input box allowed
												$(wrapper)
														.append(
																// Input do botão a ser criado
																'<div><input type="text" id="Texto'+x+'" name="conteudo" placeholder="alternativa incorreta"/><a href="#" class="excluir">X</a></div>'); //add input box
												// Incremento do botão dizendo que um campo foi adicionado
												x++;

											}

										});

						$(wrapperSubmit)
								.on(
										// Quando clicar no botão de cadastrar, faça esta ação
										"click",
										".salvar_todos",
										function(e) {
											// Alternativas sem estar vazia
											var valorAlternativa = 1;
											// Auxiliar para evitar repetição de 'alert'
											var aux = 0;
											// Preencher todos os campos
											function preencher() {
												// Caso alguma alternativa esteja vazia e este método tenha sido chamado pela primeira vez
												if (valorAlternativa == 0
														&& aux == 0) {
													alert("Preencha todas as alternativas");
													aux = 1;
												}
											}
											// Mínimo de 4 alternativas criadas
											function minimo4() {
												// Caso não tenha sido criado 4 alternativas no mínimo
												if ((x - 1) < min_fields) {
													alert("Mínimo de 4 alternativas");
												}
											}
											// Cadastrar Alternativas
											function cadastrar() {
												// Caso haja no mínimo 4 alternativas e todas as alternativas estejam preenchidas
												if (valorAlternativa == 1
														&& (x - 1) >= min_fields) {
													// Submit do formulário
													$("#target").submit()
													x--;
												}
											}

											// Verificar quantas alternativas foram criadas
											minimo4();

											// For para verificar se todas as alternativas estão preenchidas
											for (i = 0; i < x; i++) {

												if (document
														.getElementById("Texto"
																+ (i + 1)).value === '') {
													valorAlternativa = 0;
													preencher();
												}

												// Caso este seja a última consulta do 'for', tente cadastrar
												if ((i + 1) == (x - 1)) {
													cadastrar();
												}

											}

										})

						// Botão para excluir uma alternativa criada
						$(wrapper).on("click", ".excluir", function(e) {
							e.preventDefault();
							// Remover div
							$(this).parent('div').remove();
							x--;
						})

					}

			);
</script>
</head>
<body>
	<form id="target" action="addAlternativa">
		<div class="input_fields_wrap">
			<div>
				<!-- Campo de inserção do texto da questão -->
				<input id="Texto1" type="text" name="respo\sta"
					placeholder="Alternativa Correta">
				<!-- Botão de adicionar alternativas -->
				<button class="add_field_button">+</button>
			</div>
		</div>
		<div class="wrapperSubmit">
			<!-- Botão de cadastro de alternativas -->
			<a href="#" class="salvar_todos">Enviar</a>
		</div>
			<label>Conteudo</label>
	<input type="text" name="conteudo"><br />
	<label>Correta</label>
	<input type="text" name="correta"><br />
	<label>ID da Questão</label>
	<input type="text" name="idQuestao" value="${questao.idQuestao}" readonly><br />
		</form>
</body>
</html>