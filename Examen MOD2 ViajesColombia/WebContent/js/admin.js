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





function myDelete(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var arrRespuestaRecibida = JSON.parse(this.responseText);
			//Renderizar la pagina
			var tableBody = "";
			document.getElementById("t1").innerHTML =  "";
			for(i=0;i<arrRespuestaRecibida.length;i++){
				tableBody +="<tr><td>" + arrRespuestaRecibida[i].nombre + "</td>" +
				"<td>" + arrRespuestaRecibida[i].primerApellido + "</td>" + 
				"<td>" + arrRespuestaRecibida[i].segundoApellido + "</td>" +
				"<td>" + arrRespuestaRecibida[i].fechaEntrada + "</td>" +
				"<td>" + arrRespuestaRecibida[i].fechaSalida + "</td>" +
				"<td>" + arrRespuestaRecibida[i].centro + "</td>" +
				"<td><input type='button'  class='btn btn-md btn-secondary-outline display-' id="+arrRespuestaRecibida[i].idCliente + " onclick = myDelete(this.id) name=" + arrRespuestaRecibida[i].idCliente +" value='X'></td></tr>";				


			}

			document.getElementById("t1").innerHTML =  tableBody;

		}
	};

	//Crear y enviar la respuesta a la peticion
	// Abrimos conexion!
	xhttp.open("POST", "AJAXUpdateDelete",true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	// Enviamos nuestro objeto PERSONA con formato JSON
	xhttp.send('action=delete&idcliente='+id);
}



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
				debugger
				strMascotas.push(document.getElementById("txtareamascotas").value);
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
			document.getElementById("t1").innerHTML =  "";
			for(i=0;i<arrRespuestaRecibida.length;i++){
				debugger;
				tableBody +="<tr><td>" + arrRespuestaRecibida[i].nombre + "</td>" +
				"<td>" + arrRespuestaRecibida[i].primerApellido + "</td>" + 
				"<td>" + arrRespuestaRecibida[i].segundoApellido + "</td>" +
				"<td>" + arrRespuestaRecibida[i].fechaEntrada + "</td>" +
				"<td>" + arrRespuestaRecibida[i].fechaSalida + "</td>" +
				"<td>" + arrRespuestaRecibida[i].centro + "</td>" +
				"<td><input type='button'  class='btn btn-md btn-secondary-outline display-' id="+arrRespuestaRecibida[i].idCliente + " onclick = myDelete(this.id) name=" + arrRespuestaRecibida[i].idCliente +" value='X'></td></tr>";				

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

	document.getElementById("name").value = "";
	document.getElementById("primerApellido").value = "";
	document.getElementById("segundoApellido").value = "";
	document.getElementById("fechaEntrada").value = "";
	document.getElementById("fechaSalida").value = "";
	document.getElementById("email").value = "";
	document.getElementById("phone-form1-b").value = "";
	document.getElementById("descripcionMascota").style = "display: none";
	document.getElementById("mascota").checked = false;
	document.getElementById("contenedorMascotas").style = "display: none";

});


document.getElementById("ctslista").addEventListener("change", function(){
	var centro = new Object();
	centro.id = 0;
	centro.nombre = this.value;
	var strJSONCentro = JSON.stringify(centro);
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// Convertimos JSON to JavaScript
			var arrRespuestaRecibida = JSON.parse(this.responseText);
			//Renderizar la pagina
			var tableBody = "";
			for(i=0;i<arrRespuestaRecibida.length;i++){
				debugger;
				tableBody +="<li class='list-group-item'>" + arrRespuestaRecibida[i].nombre + " " + arrRespuestaRecibida[i].primerApellido + "</li>";
			}

			document.getElementById("listano").innerHTML =  tableBody;


		}
	};

	//Crear y enviar la respuesta a la peticion
	// Abrimos conexion!
	xhttp.open("POST", "AJAXCentros",true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	// Enviamos nuestro objeto PERSONA con formato JSON
	xhttp.send("jsondata=" + strJSONCentro);

});

document.getElementById("name").addEventListener('focusout', checkName);
document.getElementById("primerApellido").addEventListener('blur', checkPrimerApellido);
document.getElementById("segundoApellido").addEventListener('blur', checkSegundoApellido);
document.getElementById("fechaEntrada").addEventListener('blur', checkDateAlta);
document.getElementById("fechaSalida").addEventListener('blur', checkDateBaja);

function checkDateAlta() {
	var dateOK = true;
	var strDate = document.getElementById("fechaEntrada").value;
	var dateDate = new Date(strDate);
	var currentDate = new Date();

	if (dateDate <= currentDate) {
		dateOK = false;
		document.getElementById("infoFechaEntrada").style = "display: inline";
		document.getElementById("fechaEntrada").focus();
	} else {
		dateOK = true;
		document.getElementById("infoFechaEntrada").style = "display: none";
	}
	return dateOK;
}

function checkName() {

	// Patron de busqueda formado por una serie de caracteres. Es usado para la busqueda y 
	//sustitucion de este patron.
	var patt = new RegExp(/^[a-zA-Z ]{2,30}$/);
	var res = patt.test(document.getElementById("name").value);
	if (!res) {
		document.getElementById("infoNombre").style = "display: inline";
		document.getElementById("name").focus();
	} else {
		document.getElementById("infoNombre").style = "display: none";
	}
	return res
}

function checkPrimerApellido() {

	// Patron de busqueda formado por una serie de caracteres. Es usado para la busqueda y 
	//sustitucion de este patron.
	var patt = new RegExp(/^[a-zA-Z ]{2,30}$/);
	var res = patt.test(document.getElementById("primerApellido").value);

	if (!res) {
		document.getElementById("infoApellido1").style = "display: inline";
		document.getElementById("primerApellido").focus();
	} else {
		document.getElementById("infoApellido1").style = "display: none";
	}
	return res
}

function checkSegundoApellido() {

	// Patron de busqueda formado por una serie de caracteres. Es usado para la busqueda y 
	//sustitucion de este patron.
	if (document.getElementById("segundoApellido").value == "") {
		res = true;
		return res;
	} else {
		var patt = new RegExp(/^[a-zA-Z ]{2,30}$/);
		debugger
		var res = patt.test(document.getElementById("segundoApellido").value);
		if (!res) {
			document.getElementById("infoApellido2").style = "display: inline";
			document.getElementById("segundoApellido").focus();
		} else {
			document.getElementById("infoApellido2").style = "display: none";
		}
	}
	return res
}

function checkDateBaja() {

	var dateOK = true;
	var strDate = document.getElementById("fechaSalida").value;
	var strDateAlta = document.getElementById("fechaEntrada").value;
	var dateAlta = new Date(strDateAlta);
	var dateBaja = new Date(strDate);

	if (dateBaja < dateAlta) {
		dateOK = false;
		document.getElementById("infoFechaSalida").style = "display: inline";
		document.getElementById("fechaSalida").focus();
	} else {
		dateOK = true;
		document.getElementById("infoFechaSalida").style = "display: none";
	}
	return dateOK;
}





