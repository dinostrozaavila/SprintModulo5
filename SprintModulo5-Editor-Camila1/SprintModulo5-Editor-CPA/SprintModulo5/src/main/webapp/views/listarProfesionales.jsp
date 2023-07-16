<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sprintmodulo5.modelo.Profesional"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Listado de Profesionales</title>

<!-- Enlace a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Listado de Profesionales:</h1>
	</div>

	<!-- Contenedor de la tabla profesionales -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>RUT</th>
						<th>Nombre</th>
						<th>Fecha de Nacimiento</th>
						<th>Título</th>
						<th>Fecha de Ingreso</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>

					<%-- Obtener la lista de profesionales del atributo "listaProfesionales" --%>
					<%
					Object listaProfesional = request.getAttribute("listaProfesionales");
					Profesional[] profesionales = null;
					if (listaProfesional instanceof List<?>) {
						List<?> lista = (List<?>) listaProfesional;
						profesionales = lista.toArray(new Profesional[lista.size()]);
					}
					%>
					<%-- Iterar sobre los profesionales y mostrar los datos --%>
					<%
					if (profesionales != null) {
						for (Profesional profesional : profesionales) {
					%>
					<tr>
						<td><%=profesional.getRut()%></td>
						<td><%=profesional.getNombre()%></td>
						<td><%=profesional.getFechaNacimiento()%></td>
						<td><%=profesional.getTitulo()%></td>
						<td><%=profesional.getFechaIngreso()%></td>
						<td><a
							href="EditarProfesionalServlet?rut=<%=profesional.getRut()%>"
							class="btn btn-primary">Editar Profesional</a></td>

						<%
						}
						}
						%>
					
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<div class="row"></div>
	</div>

	<%@ include file="/views/footer.jsp"%>

	<!-- Agregar el enlace al archivo JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>