<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="cc"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <!-- Site made with Mobirise Website Builder v4.8.7, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.8.7, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assetsListado/images/logo4.png" type="image/x-icon">
  <meta name="description" content="">
  <link rel="stylesheet" href="assetsListado/assetsListado/tether/tether.min.css">
  <link rel="stylesheet" href="assetsListado/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assetsListado/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assetsListado/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assetsListado/datatables/data-tables.bootstrap4.min.css">
  <link rel="stylesheet" href="assetsListado/theme/css/style.css">
  <link rel="stylesheet" href="assetsListado/mobirise/css/mbr-additional.css" type="text/css">
  
<title>CONSULTA DE RESERVAS</title>
</head>
<body>
<body>
	<section
		class="mbr-section content5 cid-r92Yylfraj mbr-parallax-background"
		id="content5-8">

		<div class="container">
			<div class="media-container-row">
				<div class="title col-12 col-md-8">
					<h2
						class="align-center mbr-bold mbr-white pb-3 mbr-fonts-style display-1">
						Listado de Reservas</h2>
					<h3
						class="mbr-section-subtitle align-center mbr-light mbr-white pb-3 mbr-fonts-style display-7">
						Usuario: ${usuario.login}</h3>

				</div>
			</div>
		</div>
	</section>

	<section class="section-table cid-r9300cw1CI" id="table1-a">

		<div class="container container-table">
				
			<div class="table-wrapper">

				<div class="container scroll">
					<jsp:useBean id="m" class="com.modelo.Modelo"></jsp:useBean>
					<table class="table isSearch" cellspacing="0">
						<thead>
							<tr class="table-heads ">

								<th class="head-item mbr-fonts-style display-7">CLIENTE</th>
								<th class="head-item mbr-fonts-style display-7">PRIMER
									APELLIDO</th>
								<th class="head-item mbr-fonts-style display-7">SEGUNDO
									APELLIDO</th>
								<th class="head-item mbr-fonts-style display-7">FECHA
									ENTRADA</th>
								<th class="head-item mbr-fonts-style display-7">FECHA
									SALIDA</th>
								<th class="head-item mbr-fonts-style display-7">CENTRO
									TURISTICO</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${m.clientes}" var="cliente">
								<tr>
				 
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.nombre}" /></td>
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.primerApellido}" /></td>
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.segundoApellido}" /></td>
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.fechaEntrada}" /></td>
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.fechaSalida}" /></td>
									<td class="body-item mbr-fonts-style display-7"><c:out
											value="${cliente.centro}" /></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<script src="assetsListado/web/assetsListado/jquery/jquery.min.js"></script>
	<script src="assetsListado/popper/popper.min.js"></script>
	<script src="assetsListado/tether/tether.min.js"></script>
	<script src="assetsListado/bootstrap/js/bootstrap.min.js"></script>
	<script src="assetsListado/smoothscroll/smooth-scroll.js"></script>
	<script src="assetsListado/parallax/jarallax.min.js"></script>
	<script src="assetsListado/datatables/jquery.data-tables.min.js"></script>
	<script src="assetsListado/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assetsListado/theme/js/script.js"></script>
</body>
</html>



