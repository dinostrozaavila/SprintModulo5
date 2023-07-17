<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Navbar JSP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">Prevencion de riesgos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/InicioServlet">Inicio</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Log/in-out </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/LoginServlet">Login</a>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/logout">Logout</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/ContactoServlet">Contacto</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Capacitacion </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/CrearCapacitacionServlet">Crear
							Capacitación</a> <a class="dropdown-item"
							href="${pageContext.request.contextPath}/ListarCapacitacionesServlet">Listar
							Capacitaciones</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Usuario </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/AgregarUsuarioServlet">Agregar
							Usuario</a> <a class="dropdown-item dropdown-toggle" href="#"
							id="listarUsuariosDropdown" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Listar Usuarios</a>
						<div class="dropdown-menu"
							aria-labelledby="listarUsuariosDropdown">
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/ListarProfesionalesServlet">Profesional</a>
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/ListarClientesServlet">Cliente</a>
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/ListarAdministrativosServlet">Administrativo</a>
						</div>
					</div></li>

			</ul>
		</div>
	</nav>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>





















