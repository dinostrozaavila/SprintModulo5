<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- Declaración de la página JSP con configuración de tipo de contenido y codificación -->

<!DOCTYPE html>
<html lang="es">
<!-- Etiqueta html con el atributo lang establecido en "es" para el idioma español -->

<head>
    <meta charset="UTF-8">
    <title>Agregar Cliente</title>
    <!-- Título de la página -->

    <link rel="stylesheet" href="views/styles.css">
    <!-- Enlace al archivo CSS para los estilos personalizados -->
    <!-- Enlace al archivo CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <%@ include file="/views/navbar.jsp" %>

    <div class="h1-container">
        <h1>Crear Cliente</h1>
    </div>
    <!-- Contenedor del encabezado principal con el título "Crear Cliente" -->

    <div class="container">
        <!-- Contenedor principal -->

        <form action="AgregarClienteServlet" method="POST">
            <!-- Formulario con acción "AgregarClienteServlet" y método "POST" -->

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="rutCliente">RUT:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="rutCliente" name="rutCliente" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="nombres">Nombres:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="nombres" name="nombres" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="apellidos">Apellidos:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="apellidos" name="apellidos" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="telefono">Teléfono:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="telefono" name="telefono" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="afp">AFP:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="afp" name="afp" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="sistemaSalud">Sistema de Salud (1 para Fonasa, 2 para Isapre):</label>
                </div>
                <div class="form-group col-md-4">
                    <select id="sistemaSalud" name="sistemaSalud" class="form-control" required>
                        <option value="1">Fonasa</option>
                        <option value="2">Isapre</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="direccion">Dirección:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="direccion" name="direccion" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="comuna">Comuna:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="comuna" name="comuna" class="form-control" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="edad">Edad:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="edad" name="edad" class="form-control" required>
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
