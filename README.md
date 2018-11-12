# ViajesColombia

Aplicacion web para la gestion de reservas en complejos hoteleros.
Esta app esta desarrollada bajo el uso de diferentes tecnologias web.

# JSP -> JavaServlet Page


Esta tecnologia nos permite desarrollar app web de forma dinamica basadas en HTML, XML en otros.
JSP se basa en el uso de etiquetas tanto HTML como etiquetas JSP, asi como el uso del scriptlet.
Scriptlet permite la inyeccion de codigo JAVA dentro de un archivo HTML. Con el uso de los caracteres <%  codigo Java %>.

 `<%  System.out.println("Esto es una prueba"); %>`

Ejemplo JSP:

 `<jsp:useBean id="m" class="com.modelo.Modelo"></jsp:useBean>`

Tambien hay que mencionar los JSTL
JavaServer Pages Standard Tag. Esta tecnoogia amplia las etiquetas de JSP, con utilidades ampliamente utilizadas el desarrollo de aplicaciones web dinamicas, como puede ser el uso de bucles forEach.
 `<c:forEach items="${m.clientes}" var="cliente">`


## Control de usuarios

La aplicacion lleva incorporado un sistema de control de usuario mediante niveles.
Si el usuario es  del   nivel 1 solo tendra permiso para ver el listado de reservas.
Si el usuario es del nivel 2 sera un usuario tipo administrador por lo que tendra acceso a la vista 'Administracion de Reservas'.

| Usuario | Contraseña | Nivel|
|--|--|--|
| scartas| scartas|1 |
| admin | admin |2 |

Esto se realiza mendiante el uso del concepto Sesion.
`HttpSession session = request.getSession();`
`session.setAttribute("currentUser", m.getUsuario());`

## Administracion de Reservas

La vista 'Administracion de Reservas' se compone de diferentes secciones:
### - Formulario de registro

### - Tabla de Reservas


### - Filtro de Rervas por centro


## JAR adicionales

---> mysql-connector-java-5.1.47.jar
---> javax.ejb.jar
---> gson-2.8.0.jar
---> jstl-1.2.jar

## Documentacion adicional

  
