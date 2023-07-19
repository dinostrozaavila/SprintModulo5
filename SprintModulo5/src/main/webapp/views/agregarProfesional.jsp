<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                    <div id="tituloError" class="alert alert-danger" role="alert" style="display: none;">El título debe tener entre 10 y 50 caracteres.</div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="fechaIngreso">Fecha de Ingreso (aaaa/mm/dd):</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="fechaIngreso" name="fechaIngreso" class="form-control" required>
                    <div id="fechaIngresoError" class="alert alert-danger" role="alert" style="display: none;">La fecha de ingreso debe tener el formato aaaa/mm/dd.</div>
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

    <script>
        $(document).ready(function() {
            $('#titulo').on('input', function() {
                var titulo = $(this).val();
                if (titulo.trim().length < 10 || titulo.trim().length > 50) {
                    $('#tituloError').show();
                } else {
                    $('#tituloError').hide();
                }
            });

            $('#fechaIngreso').on('input', function() {
                var fechaIngreso = $(this).val();
                if (!/^(\d{4})\/(\d{2})\/(\d{2})$/.test(fechaIngreso)) {
                    $('#fechaIngresoError').show();
                } else {
                    $('#fechaIngresoError').hide();
                }
            });
        });
    </script>
    <!-- Script para mostrar las alertas en tiempo real -->
</body>

</html>
