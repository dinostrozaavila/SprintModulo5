<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="sprintmodulo5.modelo.Cliente"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Editar Cliente</title>
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Editar Cliente</h1>
	</div>

	<div class="container">
		<form action="EditarClienteServlet" method="post">
			<%-- Obtener el cliente a editar del atributo "cliente" --%>
			<%
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			%>
			<input type="hidden" name="rutCliente"
				value="<%=cliente.getRutCliente()%>">

			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					name="telefono" value="<%=cliente.getTelefono()%>"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="afp">AFP:</label> <input type="text" name="afp"
					value="<%=cliente.getAfp()%>" class="form-control">
			</div>
			<div class="form-group col-md-4">
				<label for="sistemaSalud">Sistema de Salud:</label> <select
					id="sistemaSalud" name="sistemaSalud" class="form-control" required>
					<option value="1"
						<%=(cliente.obtenerSistemaSalud().equals("Fonasa")) ? "selected" : ""%>>Fonasa</option>
					<option value="2"
						<%=(cliente.obtenerSistemaSalud().equals("Isapre")) ? "selected" : ""%>>Isapre</option>

				</select>


			</div>
			<div class="form-group">
				<label for="direccion">Dirección:</label> <input type="text"
					name="direccion" value="<%=cliente.getDireccion()%>"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="comuna">Comuna:</label> <input type="text" name="comuna"
					value="<%=cliente.getComuna()%>" class="form-control">
			</div>
			<div class="form-group">
				<label for="edad">Edad:</label> <input type="text" name="edad"
					value="<%=cliente.getEdad()%>" class="form-control">
			</div>
			<div class="form-group">
				<label for="nombres">Nombres:</label> <input type="text"
					name="nombres" value="<%=cliente.getNombres()%>"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="apellidos">Apellidos:</label> <input type="text"
					name="apellidos" value="<%=cliente.getApellidos()%>"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="fechaNacimiento">Fecha de Nacimiento:</label> <input
					type="text" name="fechaNacimiento"
					value="<%=cliente.getFechaNacimiento()%>" class="form-control">
			</div>

			<input type="submit" value="Guardar" name="rutCliente"
				value="<%=cliente.getRutCliente()%>" class="btn btn-primary">

		</form>
	</div>

	<%@ include file="/views/footer.jsp"%>

	<!-- Agregar el enlace al archivo JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
