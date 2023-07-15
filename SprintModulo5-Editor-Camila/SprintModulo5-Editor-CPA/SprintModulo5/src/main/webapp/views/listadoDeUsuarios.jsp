<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sprintmodulo5.modelo.Usuario"%>
<%@ page import="sprintmodulo5.modelo.Cliente"%>
<%@ page import="sprintmodulo5.modelo.Profesional"%>
<%@ page import="sprintmodulo5.modelo.Administrativo"%>
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
					<%-- Iterar sobre las usuarios y mostrar los datos --%>
					<%
					if (usuarios != null) {
						for (Usuario usuario : usuarios) {
					%>
					<tr>
						<td><%=usuario.getNombre()%></td>
						<td><%=usuario.getFechaNacimiento()%></td>
						<td><%=usuario.getRut()%></td>
						<td><%=usuario.getTipoUsuario()%></td>
						<td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<div class="h1-container">
		<h1>Datos de Clientes:</h1>
	</div>

	<!-- Contenedor de la tabla clientes -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>Teléfono</th>
						<th>AFP</th>
						<th>Sistema de Salud</th>
						<th>Dirección</th>
						<th>Comuna</th>
						<th>Edad</th>
						<th>RUT</th>
						<th>Nombre</th>
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
						<td><%=cliente.getTelefono()%></td>
						<td><%=cliente.getAfp()%></td>
						<td><%=cliente.getSistemaSalud()%></td>
						<td><%=cliente.getDireccion()%></td>
						<td><%=cliente.getComuna()%></td>
						<td><%=cliente.getEdad()%></td>
						<td><%=cliente.getRut()%></td>
						<td><%=cliente.getNombre()%></td>
						<td><a
							href="EditarClienteServlet?rutCliente=<%=cliente.getRutCliente()%>"
							class="btn btn-primary">Editar Cliente</a></td>

						<%
						}
						}
						%>
					
				</tbody>
			</table>
		</div>
	</div>

	<div class="h1-container">
		<h1>Datos de Administrativos:</h1>
	</div>

	<!-- Contenedor de la tabla administrativos -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>Área</th>
						<th>Experiencia Previa</th>
						<th>RUT</th>
						<th>Nombre</th>
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
						<td><%=administrativo.getArea()%></td>
						<td><%=administrativo.getExperienciaPrevia()%></td>
						<td><%=administrativo.getRut()%></td>
						<td><%=administrativo.getNombre()%></td>
						<td><a
							href="EditarAdministrativoServlet?rut=<%=administrativo.getRut()%>"
							class="btn btn-primary">Editar Administrativo</a></td>

						<%
						}
						}
						%>
					
				</tbody>
			</table>
		</div>
	</div>

	<div class="h1-container">
		<h1>Datos de Profesionales:</h1>
	</div>

	<!-- Contenedor de la tabla administrativos -->
	<div class="capacitaciones-container">
		<div class="overflow-auto">
			<table class="table table-responsive custom-table">
				<thead>
					<tr>
						<th>Título</th>
						<th>Fecha de Ingreso</th>
						<th>RUT</th>
						<th>Nombre</th>
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
						<td><%=profesional.getTitulo()%></td>
						<td><%=profesional.getFechaIngreso()%></td>
						<td><%=profesional.getRut()%></td>
						<td><%=profesional.getNombre()%></td>
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