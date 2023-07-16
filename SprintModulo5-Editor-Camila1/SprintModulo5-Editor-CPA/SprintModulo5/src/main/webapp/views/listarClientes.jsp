<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sprintmodulo5.modelo.Cliente"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>

<!-- Enlace a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Listado de Clientes:</h1>
	</div>

	<!-- Contenedor de la tabla clientes -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>RUT</th>
						<th>Nombre</th>
						<th>Fecha de Nacimiento</th>
						<th>Teléfono</th>
						<th>AFP</th>
						<th>Sistema de Salud</th>
						<th>Dirección</th>
						<th>Comuna</th>
						<th>Edad</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<%-- Obtener la lista de clientes del atributo "listaClientes" --%>
					<%
					Object listaCliente = request.getAttribute("listaClientes");
					Cliente[] clientes = null;
					if (listaCliente instanceof List<?>) {
						List<?> lista = (List<?>) listaCliente;
						clientes = lista.toArray(new Cliente[lista.size()]);
					}
					%>
					<%-- Iterar sobre los clientes y mostrar los datos --%>
					<%
					if (clientes != null) {
						for (Cliente cliente : clientes) {
					%>
					<tr>
						<td><%=cliente.getRut()%></td>
						<td><%=cliente.getNombre()%></td>
						<td><%=cliente.getFechaNacimiento()%></td>
						<td><%=cliente.getTelefono()%></td>
						<td><%=cliente.getAfp()%></td>
						<td><%=cliente.obtenerSistemaSalud()%></td>
						<td><%=cliente.getDireccion()%></td>
						<td><%=cliente.getComuna()%></td>
						<td><%=cliente.getEdad()%></td>
						<td><a
							href="EditarClienteServlet?rut=<%=cliente.getRut()%>"
							class="btn btn-primary">Editar Cliente</a></td>

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