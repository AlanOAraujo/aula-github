<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>


<c:import url="../_comum/header.jsp" />

	<table class="table">
	
		<thead>
			<tr>Data</tr>
			<tr>Horas Normais</tr>
			<tr>Horas Extras</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${relatorio.horasPorDias}" var="horas">
				<tr>
					
					<td>${horas.data.time}</td>
					<td>${horas.horasNormais}</td>
					<td>${horas.horasExtras}</td>
				
				</tr>
			</c:forEach>
		
		</tbody>
		
	</table>

<c:import url="../_comum/footer.jsp" />