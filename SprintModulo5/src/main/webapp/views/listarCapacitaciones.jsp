<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="sprintmodulo5.modelo.Capacitacion"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Listar Capacitaciones</title>

<!-- Enlace a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Listar Capacitaciones</h1>
	</div>

	<!-- Contenedor de la tabla capacitaciones -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>Identificador</th>
						<th>RUT Cliente</th>
						<th>Día</th>
						<th>Hora</th>
						<th>Lugar</th>
						<th>Duración (minutos)</th>
						<th>Cantidad de Asistentes</th>
					</tr>
				</thead>
				<tbody>
					<%-- Obtener la lista de capacitaciones del atributo "listaCapacitaciones" --%>
					<%
					Object listaObj = request.getAttribute("listaCapacitaciones");
					Capacitacion[] capacitaciones = null;
					if (listaObj instanceof List<?>) {
						List<?> lista = (List<?>) listaObj;
						capacitaciones = lista.toArray(new Capacitacion[lista.size()]);
					}
					%>
					<%-- Iterar sobre las capacitaciones y mostrar los datos --%>
					<%
					if (capacitaciones != null) {
						for (Capacitacion capacitacion : capacitaciones) {
					%>
					<tr>
						<td><%=capacitacion.getIdentificador()%></td>
						<td><%=capacitacion.getRutCliente()%></td>
						<td><%=capacitacion.getDia()%></td>
						<td><%=capacitacion.getHora()%></td>
						<td><%=capacitacion.getLugar()%></td>
						<td><%=capacitacion.getDuracion()%></td>
						<td><%=capacitacion.getCantidad()%></td>
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







