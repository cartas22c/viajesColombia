<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="cc"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONSULTA DE RESERVAS</title>
</head>
<body>
	<div class="container">
		<h2>Bordered Table</h2>
		<p>The .table-bordered class adds borders on all sides of the
			table and the cells:</p>

		<h2>Listado de Estudiantes</h2>
		<!-- Usamos Etiquetas para sustituir a los scriptlets ya no hacemos inyecciones de codigo JAVA en la vista -->
		<jsp:useBean id="m" class="com.modelo.Modelo"></jsp:useBean>


		<!-- JavaServer Pages Standard Tag Library -->
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Primer Apellido</th>
					<th>Segundo Apellido</th>
					<th>Fecha Entrada</th>
					<th>Fecha Salida</th>
					<th>Centro Turistico</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${m.clientes}" var="cliente">
					<tr>
						<td><c:out value="${cliente.nombre}" /></td>
						<td><c:out value="${cliente.primerApellido}" /></td>
						<td><c:out value="${cliente.segundoApellido}" /></td>
						<td><c:out value="${cliente.fechaEntrada}" /></td>
						<td><c:out value="${cliente.fechaSalida}" /></td>
						<td><c:out value="${cliente.idCT}" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>