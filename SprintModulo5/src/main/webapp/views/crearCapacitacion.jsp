<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Declaración de la página JSP con configuración de tipo de contenido y codificación -->

<!DOCTYPE html>
<html lang="es">
<!-- Etiqueta html con el atributo lang establecido en "es" para el idioma español -->

<head>
<meta charset="UTF-8">
<title>Crear Capacitación</title>
<!-- Título de la página -->

<link rel="stylesheet" href="views/styles.css">
<!-- Enlace al archivo CSS para los estilos personalizados -->
<!-- Enlace al archivo CSS de Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="/views/navbar.jsp"%>

	<div class="h1-container">
		<h1>Crear Capacitación</h1>
	</div>
	<!-- Contenedor del encabezado principal con el título "Crear Capacitación" -->

	<div class="container">
		<!-- Contenedor principal -->

		<form accept-charset="UTF-8" action="CrearCapacitacionServlet"
			method="POST">
			<!-- Formulario con acción "CrearCapacitacionServlet" y método "POST" -->


			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="rutCliente">RUT del Cliente:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="rutCliente" name="rutCliente"
						class="form-control" required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="dia">Día de la Capacitación:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="dia" name="dia" class="form-control"
						required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="hora">Hora de la Capacitación:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="hora" name="hora" class="form-control"
						required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="lugar">Lugar de la Capacitación:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="lugar" name="lugar" class="form-control"
						required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="duracion">Duración de la Capacitación:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="duracion" name="duracion" required>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="cantidad">Cantidad de Asistentes:</label>
				</div>
				<div class="form-group col-md-2">
					<input type="text" id="cantidad" name="cantidad" required>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Agregar</button>
			<!-- Botón de envío del formulario -->
		</form>
	</div>

	<%-- Verificar si se debe mostrar el mensaje de confirmación --%>
	<%
	if (request.getAttribute("guardadoExitoso") != null) {
	%>
	<div class="alert alert-success" role="alert">¡La capacitación se
		ha creado exitosamente!</div>
	<%
	}
	%>

	<!-- Agregar el enlace al archivo JS de jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- Enlace al archivo JS de Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>







