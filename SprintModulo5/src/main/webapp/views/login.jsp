<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Enlaces a hojas de estilo personalizadas -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
	<!-- Incluir el Navbar -->
	<%@include file="navbarLogin.jsp"%>
	<div class="h1-container">
		<h1>Login</h1>
	</div>

	<!-- Formulario del caso de uso login -->
	<div class="form-container login-form-container">
		<form action="LoginServlet" method="POST">
			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="username">Nombre de usuario:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" id="username" name="username" class="form-control" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="password">Contraseña:</label>
				</div>
				<div class="form-group col-md-4">
					<input type="password" id="password" name="password" class="form-control" required>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ingresar</button>
		</form>
	</div>

	<!-- Incluir el Footer -->
	<%@ include file="/views/footer.jsp"%>

	<!-- Agregar el enlace al archivo JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

	<script>
		$(document).ready(function() {
			$('#username').on('input', function() {
				var username = $(this).val();
				if (username.trim().length === 0) {
					$('#usernameError').show();
				} else {
					$('#usernameError').hide();
				}
			});


			$('#password').on('input', function() {
				var mensaje = $(this).val();
				if (mensaje.trim().length === 0) {
					$('#passwordError').show();
				} else {
					$('#passwordError').hide();
				}
			});
		});
	</script>

</html>







