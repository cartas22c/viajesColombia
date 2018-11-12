<%@taglib uri="http://java.sun.com/jstl/core" prefix="cc"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<!-- Site made with Mobirise Website Builder v4.8.7, https://mobirise.com -->
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.8.7, mobirise.com">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="assetsReserva/images/logo4.png"
	type="image/x-icon">
<meta name="description" content="">
<title>Admin Reservas</title>
<link rel="stylesheet" href="assetsReserva/tether/tether.min.css">
<link rel="stylesheet"
	href="assetsReserva/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assetsReserva/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assetsReserva/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet"
	href="assetsReserva/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assetsReserva/theme/css/style.css">
<link rel="stylesheet"
	href="assetsReserva/mobirise/css/mbr-additional.css" type="text/css">



</head>
<body>
	<section
		class="mbr-section content5 cid-r92Yylfraj mbr-parallax-background"
		id="content5-8">

		<div class="container">
			<div class="media-container-row">
				<div class="title col-12 col-md-8">
					<h2
						class="align-center mbr-bold mbr-white pb-3 mbr-fonts-style display-1">Administración
						Reservas</h2>
					<h3
						class="mbr-section-subtitle align-center mbr-light mbr-white pb-3 mbr-fonts-style display-7">
						Usuario: ${usuario.login}</h3>


				</div>
			</div>
		</div>
	</section>





	<div class="container">
		<div class="row justify-content-center">
			<div class="title col-12 col-lg-8">
				</br>
				<h2
					class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
					Registar Reserva</h2>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="media-container-column col-lg-8" data-form-type="formoid">
				<div data-form-alert="" hidden="">Thanks for filling out the
					form!</div>

				<form class="mbr-form" data-form-title="Mobirise Form">
					<input type="hidden" name="email" data-form-email="true"
						value="ZhJKGK7lL8Wn/PoyF2ewnv80Vx+03qDniQSXV0gIKJ3jyLGAg3KqQBPT8NA++K21mcSMO1cJ2oZnENzkAfrpXE+Usdt0KKhFuprtGbm6AL9/JCXizFwOvbUMSyY/mow=">
					<div class="row row-sm-offset">
						<div class="col-md-4 multi-horizontal" data-for="name">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="name">Nombre</label> <input type="text"
									class="form-control" name="name" data-form-field="Name"
									id="name" required="required"> <span
									style="display:none; color:#fc1751; font-weight:bold;"
									id="infoNombre">Solo letras y espacios. Debe comenzar
									por mayuscula</span>

							</div>
						</div>
						<div class="col-md-4 multi-horizontal" data-for="primerApellido">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="primerApellido">Primer Apellido</label> <input type="text"
									class="form-control" name="primerApellido"
									data-form-field="primerApellido" id="primerApellido"
									required="required"> <span style="display:none; color:#fc1751; font-weight:bold;" id="infoApellido1">Solo
									letras y espacios. Debe comenzar por mayuscula</span>

							</div>
						</div>
						<div class="col-md-4 multi-horizontal" data-for="segundoApellido">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="segundoApellido">Segundo Apellido</label> <input
									type="text" class="form-control" name="segundoApellido"
									data-form-field="segundoApellido" id="segundoApellido">
								<span style="display:none; color:#fc1751; font-weight:bold;" id="infoApellido2">Solo letras y espacios. Debe
									comenzar por mayuscula</span>

							</div>
						</div>
						<div class="col-md-4 multi-horizontal" data-for="email">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="email">Email</label> <input type="text"
									class="form-control" name="email" data-form-field="email"
									required="required" id="email">
							</div>
						</div>

						<div class="col-md-4 multi-horizontal" data-for="phone">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="phone-form1-b">Phone</label> <input type="text"
									class="form-control" name="phone" data-form-field="Phone"
									id="phone-form1-b" required="required">
							</div>
						</div>


						<div class="col-md-2 multi-horizontal" data-for="sexo">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="hombre">Hombre</label> <input type="radio"
									class="form-control" data-form-field="sexo" name="sexo"
									value="H" id="hombre">
							</div>
						</div>


						<div class="col-md-2 multi-horizontal" data-for="sexo">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"
									for="mujer">Mujer</label> <input type="radio"
									class="form-control" data-form-field="sexo" name="sexo"
									value="M" id="mujer">
							</div>
						</div>
					</div>



					<div class="col-md-4 multi-horizontal" data-for="fechaEntrada">
						<div class="form-group">
							<label class="form-control-label mbr-fonts-style display-7"
								for="fechaEntrada">Fecha Entrada</label> <input type="date"
								class="form-control" name="fechaEntrada"
								data-form-field="fechaEntrada" required="required"
								id="fechaEntrada"> <span style="display:none; color:#fc1751; font-weight:bold;"  id="infoFechaEntrada">La
								fecha de Entrada no puede ser menor que la fecha actual</span>

						</div>
					</div>

					<div class="col-md-4 multi-horizontal" data-for="fechaSalida">
						<div class="form-group">
							<label class="form-control-label mbr-fonts-style display-7"
								for="fechaSalida">Fecha Salida</label> <input type="date"
								class="form-control" name="fechaSalida"
								data-form-field="fechaSalida" required="required"
								id="fechaSalida"> <span style="display:none; color:#fc1751; font-weight:bold;" id="infoFechaSalida">La
								fecha de Salida no puede ser menor que la fecha de Entrada</span>

						</div>
					</div>

					<div class="col-md-3 multi-horizontal" data-for="sexo">
						<div class="form-group">
							<jsp:useBean id="m" class="com.modelo.Modelo"></jsp:useBean>
							<label class="form-control-label mbr-fonts-style display-7"
								for="cts">Seleccione Centro</label> </br> <select id="cts">
								<option></option>
								<c:forEach items="${m.centros}" var="centro">
									<option value="${centro.nombre}">${centro.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>


					<div class="col-md-2 multi-horizontal" data-for="sexo">
						<div class="form-group">
							<label class="form-control-label mbr-fonts-style display-7"
								for="mascota">Tiene mascota?</label> <input type="checkbox"
								id="mascota" name="mascota">
							<div id="contenedorMascotas">
								<label class="form-control-label mbr-fonts-style display-7"
									for="mascotas">Mascotas:</label> <select id="mascotas" multiple>
									<option value="Perro">Perro</option>
									<option value="Gato">Gato</option>
									<option value="O">Otro tipo</option>
								</select>
							</div>
							<div id="descripcionMascota">
								<h4>Describa su mascota</h4>
								<input type="text" id="txtareamascotas">

							</div>
						</div>
					</div>


					<input type="button"
						class="btn btn-md btn-secondary-outline display-4" id="registrar"
						name="registar" value="Registar">
				</form>
			</div>
		</div>
	</div>

	<br>
	<div class="container scroll">
		<table class="table isSearch" cellspacing="0">
			<thead>
				<tr class="table-heads ">

					<th class="head-item mbr-fonts-style display-7">CLIENTE</th>
					<th class="head-item mbr-fonts-style display-7">PRIMER
						APELLIDO</th>
					<th class="head-item mbr-fonts-style display-7">SEGUNDO
						APELLIDO</th>
					<th class="head-item mbr-fonts-style display-7">FECHA ENTRADA</th>
					<th class="head-item mbr-fonts-style display-7">FECHA SALIDA</th>
					<th class="head-item mbr-fonts-style display-7">CENTRO
						TURISTICO</th>
					<th class="head-item mbr-fonts-style display-10"></th>
					<th class="head-item mbr-fonts-style display-10"></th>
			</thead>

			<tbody id="t1">
				<jsp:useBean id="m2" class="com.modelo.Modelo"></jsp:useBean>

				<c:forEach items="${m2.clientes}" var="cliente">
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
						<td><input type='button'
							class='btn btn-md btn-secondary-outline display-'
							id="${cliente.idCliente}" name="${cliente.idCliente}" value='X'
							onclick="myDelete(this.id)"></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<h2>Lista No ordenada Clientes</h2>
		<div class="col-md-3 multi-horizontal" data-for="sexo">
			<div class="form-group">
				<jsp:useBean id="m1" class="com.modelo.Modelo"></jsp:useBean>
				<label class="form-control-label mbr-fonts-style display-7"
					for="ctslista">Seleccione Centro</label> </br> <select id="ctslista">
					<option></option>
					<c:forEach items="${m1.centros}" var="centro">
						<option value="${centro.nombre}">${centro.nombre}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<ul class="list-group" id="listano">

		</ul>
	</div>


	<script type="text/javascript" src="js/admin.js"></script>
	<script src="assetsReserva/popper/popper.min.js"></script>
	<script src="assetsReserva/tether/tether.min.js"></script>
	<script src="assetsReserva/bootstrap/js/bootstrap.min.js"></script>
	<script src="assetsReserva/smoothscroll/smooth-scroll.js"></script>
	<script src="assetsReserva/parallax/jarallax.min.js"></script>
	<script src="assetsReserva/datatables/data-tables.bootstrap4.min.js"></script>


</body>
</html>