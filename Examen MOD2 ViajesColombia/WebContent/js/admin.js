/**
 * 
 */


document.getElementById("mascota").addEventListener('change', function () {
	if (this.checked) {
		document.getElementById("contenedorMascotas").style = "display: block";
	} else {
		document.getElementById("contenedorMascotas").style = "display: none";
		document.getElementById("descripcionMascota").style = "display: none";
	}
});


document.getElementById("mascotas").addEventListener('change', function () {
	// Recorremos las opciones del seleccionador
	var mascotasSelected = [];
	for (i = 0; i < this.options.length; i++) {
		if (this.options[i].selected) {
			mascotasSelected.push(this.options[i].value);
		}
	}
	if (mascotasSelected.includes('O')) {
		document.getElementById("descripcionMascota").style = "display: block";
	} else {
		document.getElementById("descripcionMascota").style = "display: none";
	}

});



//Funcion para la creacion de Cliente - Telefono - Correo

document.getElementById("registrar").addEventListener("click", function() {

	var cliente = new Object();
	debugger;
	cliente.nombre = document.getElementById("name").value;
	cliente.primerApellido = document.getElementById("primerApellido").value;
	cliente.segundoApellido = document.getElementById("segundoApellido").value;
	if (document.getElementById('hombre').checked) {
		cliente.sexo = document.getElementById('hombre').value;
	}else{
		cliente.sexo = document.getElementById('mujer').value;
	}
 	cliente.fechaEntrada = document.getElementById("fechaEntrada").value;
	cliente.fechaSalida = document.getElementById("fechaSalida").value;

	var arrEmail = document.getElementById("email").value.split(";");
	cliente.email = arrEmail;

	var arrPhones = document.getElementById("phone-form1-b").value.split(";");
	cliente.telefonos = arrPhones;

	cliente.centro = document.getElementById("cts").value;
	
	var mascotasSelected = [];
	if(document.getElementById("mascotas")!= null){
		for (i = 0; i < document.getElementById("mascotas").options.length; i++) {
			if (document.getElementById("mascotas").options[i].selected) {
				mascotasSelected.push(document.getElementById("mascotas").options[i].value);
			}
		}
		var strMascotas = [];
		for(i = 0; i< mascotasSelected.length;i++){
			if(mascotasSelected[i] != "O"){
				strMascotas.push(mascotasSelected[i]);}
			else{
				strMascotas.push(document.getElementById("descripcionMascota").value);
			}
		}
		cliente.mascotas = strMascotas;
	}  // Fin bloque mascotas





	var strJSONCliente = JSON.stringify(cliente);
	// Creamos el objeto para poder enviar Persona por AJAX
	var xhttp = new XMLHttpRequest();


	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// Convertimos JSON to JavaScript
			var arrRespuestaRecibida = JSON.parse(this.responseText);
			//Renderizar la pagina
			var tableBody = "";
			for(i=0;i<arrRespuestaRecibida.length;i++){
				tableBody +="<tr><td>" + arrRespuestaRecibida[i].nombre + "</td>" +
				"<td>" + arrRespuestaRecibida[i].primerApellido + "</td>" + 
				"<td>" + arrRespuestaRecibida[i].segundoApellido + "</td></tr>";
			}

			document.getElementById("t1").innerHTML =  tableBody;


		}
	};

	//Crear y enviar la respuesta a la peticion
	// Abrimos conexion!
	xhttp.open("POST", "AJAXManager",true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	// Enviamos nuestro objeto PERSONA con formato JSON
	xhttp.send("jsondata=" + strJSONCliente);
});




