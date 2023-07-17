<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sprintmodulo5.modelo.Administrativo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Listado de Administrativos</title>
<!-- Enlace a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Listado de Administrativos:</h1>
	</div>

	<!-- Contenedor de la tabla administrativos -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>RUT</th>
						<th>Nombre</th>
						<th>Fecha de Nacimiento</th>
						<th>Área</th>
						<th>Experiencia Previa</th>
						<th>Editar</th>
						
					</tr>
				</thead>
				<tbody>
					<%-- Obtener la lista de administrativos del atributo "listaAdministrativos" --%>
					<%
					Object listaAdministrativo = request.getAttribute("listaAdministrativos");
					Administrativo[] administrativos = null;
					if (listaAdministrativo instanceof List<?>) {
						List<?> lista = (List<?>) listaAdministrativo;
						administrativos = lista.toArray(new Administrativo[lista.size()]);
					}
					%>
					<%-- Iterar sobre los clientes y mostrar los datos --%>
					<%
					if (administrativos != null) {
						for (Administrativo administrativo : administrativos) {
					%>
					<tr>
						<td><%=administrativo.getRut()%></td>
						<td><%=administrativo.getNombre()%></td>
						<td><%=administrativo.getFechaNacimiento()%></td>
						<td><%=administrativo.getArea()%></td>
						<td><%=administrativo.getExperienciaPrevia()%></td>
						<td><a
							href="EditarAdministrativoServlet?id=<%=administrativo.getIdAdministrativo()%>"
							class="btn btn-primary">Editar Administrativo</a></td>

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