<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- Declaración de la página JSP con configuración de tipo de contenido y codificación -->

<!DOCTYPE html>
<html lang="es">
<!-- Etiqueta html con el atributo lang establecido en "es" para el idioma español -->

<head>
    <meta charset="UTF-8">
    <title>Agregar Profesional</title>
    <!-- Título de la página -->

    <link rel="stylesheet" href="views/styles.css">
    <!-- Enlace al archivo CSS para los estilos personalizados -->
    <!-- Enlace al archivo CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <%@ include file="/views/navbar.jsp" %>

    <div class="h1-container">
        <h1>Agregar Profesional</h1>
    </div>
    <!-- Contenedor del encabezado principal con el título "Crear Cliente" -->

    <div class="container">
        <!-- Contenedor principal -->

        <form action="AgregarProfesionalServlet" method="POST">
            <!-- Formulario con acción "AgregarClienteServlet" y método "POST" -->

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="titulo">Titulo:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="titulo" name="titulo" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="fechaIngreso">Fecha de Ingreso:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="fechaIngreso" name="fechaIngreso" class="form-control" required>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Agregar</button>
            <!-- Botón de envío del formulario -->
        </form>
    </div>

    <% if ("true".equals(request.getAttribute("mostrarVentanaEmergente"))) { %>
        <script>
            alert("Guardado exitoso");
        </script>
    <% } %>
    <!-- Script para mostrar una ventana emergente si se ha guardado exitosamente -->

    <%@ include file="/views/footer.jsp" %>
    <!-- Inclusión del archivo JSP que contiene el footer -->

    <!-- Agregar el enlace al archivo JS de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Inclusión de jQuery -->
</body>

</html>