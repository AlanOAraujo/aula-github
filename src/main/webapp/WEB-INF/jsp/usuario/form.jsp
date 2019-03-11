<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>

<c:import url="../_comum/header.jsp" />

	<form action="${linkTo[UsuarioController].adiciona(null) }" method="POST">
		<label for="nome">Nome:</label> <input type="text" name="usuario.nome"
			id="nome" class="form-control" value="${usuario.nome}" />
		<alura:validationMessage name="usuario.nome"></alura:validationMessage>
	
		<label for="email">Email:</label> <input type="email"
			name="usuario.email" id="email" class="form-control"
			value="${usuario.email}" />
		<alura:validationMessage name="usuario.email"></alura:validationMessage>
	
		<label for="login">Login:</label> <input type="text"
			name="usuario.login" id="login" class="form-control"
			value="${usuario.login}" />
		<alura:validationMessage name="usuario.login"></alura:validationMessage>
	
		<label for="senha">Senha:</label> <input type="password"
			name="usuario.senha" id="senha" class="form-control" />
		<alura:validationMessage name="usuario.senha"></alura:validationMessage>
	
		<input type="submit" value="Cadastrar" class="btn" />
	</form>

<c:import url="../_comum/footer.jsp" />