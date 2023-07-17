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
		<form action="EditarClienteServlet" method="POST">
			<%-- Obtener el cliente a editar del atributo "cliente" --%>
			<%
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			%>
			<input type="hidden" name="id" value="<%=cliente.getIdCliente()%>">

			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					name="telefono" value="<%=cliente.getTelefono()%>"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="afp">AFP:</label> <input type="text" name="afp"
					value="<%=cliente.getAfp()%>" class="form-control">
			</div>
			<div class="form-group">
				<label for="sistemaSalud">Sistema de Salud:</label> <select
					id="sistemaSalud" name="sistemaSalud" class="form-control" required>
					<option value="1"
						<%=String.valueOf(cliente.getSistemaSalud()).equals("1") ? "selected" : ""%>>Fonasa</option>
					<option value="2"
						<%=String.valueOf(cliente.getSistemaSalud()).equals("2") ? "selected" : ""%>>Isapre</option>
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

			<input type="submit" value="Guardar" class="btn btn-primary">

		</form>
	</div>
	<%
	if ("true".equals(request.getAttribute("mostrarVentanaEmergente"))) {
	%>
	<script>
		alert("Guardado exitoso");
	</script>
	<%
	}
	%>

	<%@ include file="/views/footer.jsp"%>

	<!-- Agregar el enlace al archivo JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
