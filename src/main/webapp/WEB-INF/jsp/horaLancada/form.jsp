<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>


<c:import url="../_comum/header.jsp" />

	<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">
	
		<label for="data">Data:</label>
		<input type="text" id="data" name="horaLancada.data" class="form-control"/>
		<alura:validationMessage name="horaLancada.data"/>
		
		<label for="horaInicial">Hora Inicial:</label>
		<input type="text" id="horaInicial" name="horaLancada.horaInicial" class="form-control"/>
		<alura:validationMessage name="horaLancada.horaInicial"/>
		
		<label for="horaFinal">Hora Final:</label>
		<input type="text" id="horaFinal" name="horaLancada.horaFinal" class="form-control"/>
		<alura:validationMessage name="horaLancada.horaFinal"/>
		
		<input type="submit" value="Cadastrar"/>
	
	</form>


<c:import url="../_comum/footer.jsp" />