<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>


<c:import url="../_comum/header.jsp" />

	<a href="${linkTo[HoraLancadaController].form()}">Cadastrar Hora</a>
	
	<a href="${linkTo[HoraLancadaController].relatorioDeHoras()}">Relatorio de Horas</a>
	
	<table class="table table-hover">
		<thead>
			<tr>
			
				<th>Id</th>
				<th>Data</th>
				<th>Hora Inicial</th>
				<th>Hora Final</th>
				<th>Duracao</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${horas}" var="horas">
			
				<tr>
					<td>${horas.id}</td>
					<td>${horas.data.time}</td>
					<td>${horas.horaInicial}</td>
					<td>${horas.horaFinal}</td>
					<td>${horas.duracao}</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
	</table>

<c:import url="../_comum/footer.jsp" />