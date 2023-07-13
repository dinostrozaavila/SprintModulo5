<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="grupal2.modelo.Usuario"%>
<%@ page import="grupal2.modelo.Cliente"%>
<%@ page import="grupal2.modelo.Profesional"%>
<%@ page import="grupal2.modelo.Administrativo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Listado de Usuarios</title>

<!-- Enlace a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Listado de Usuarios</h1>
	</div>

	<!-- Contenedor de la tabla usuarios -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>Nombre de Usuario</th>
						<th>Fecha de nacimiento</th>
						<th>Run</th>
						<th>Tipo de Usuario</th>
						<th>Datos Adicionales</th>
					</tr>
				</thead>
				<tbody>
					<%-- Obtener la lista de usuarios del atributo "listaUsuarios" --%>
					<%
					Object listaObj = request.getAttribute("listaUsuarios");
					Usuario[] usuarios = null;
					if (listaObj instanceof List<?>) {
						List<?> lista = (List<?>) listaObj;
						usuarios = lista.toArray(new Usuario[lista.size()]);
					}
					%>
					<%-- Iterar sobre las capacitaciones y mostrar los datos --%>
					<%
					if (usuarios != null) {
						for (Usuario usuario : usuarios) {
					%>
					<tr>
						<td><%=usuario.getNombre()%></td>
						<td><%=usuario.getFechaNacimiento()%></td>
						<td><%=usuario.getRun()%></td>
						<td><%=usuario.getTipoUsuario()%></td>
						<td>
							<%-- Verificar el tipo de usuario y mostrar los datos adicionales correspondientes --%>
							<%
							if (usuario instanceof Cliente) {
								Cliente cliente = (Cliente) usuario;
							%>
								<strong>Cliente:</strong> Algunos datos específicos del cliente
							<%
							} else if (usuario instanceof Profesional) {
								Profesional profesional = (Profesional) usuario;
							%>
								<strong>Profesional:</strong> Título: <%=profesional.getTitulo()%>, Fecha de ingreso: <%=profesional.getFechaIngreso()%>
							<%
							} else if (usuario instanceof Administrativo) {
								Administrativo administrativo = (Administrativo) usuario;
							%>
								<strong>Administrativo:</strong> Área: <%=administrativo.getArea()%>, Experiencia previa: <%=administrativo.getExperienciaPrevia()%>
							<%
							}
							%>
						</td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/views/footer.jsp"%>

	<!-- Agregar el enlace al archivo JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
