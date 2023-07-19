<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <%@ include file="/views/navbar.jsp"%>

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
                    <label for="telefono">Teléfono:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="telefono" name="telefono" class="form-control" required>
                    <div id="telefonoError" class="alert alert-danger" role="alert" style="display: none;">El teléfono es obligatorio.</div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="afp">AFP:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="afp" name="afp" class="form-control" required>
                    <div id="afpError" class="alert alert-danger" role="alert" style="display: none;">La AFP es obligatoria y debe tener entre 4 y 30 caracteres.</div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="sistemaSalud">Sistema de Salud:</label>
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
                    <div id="direccionError" class="alert alert-danger" role="alert" style="display: none;">La dirección es obligatoria y debe tener un máximo de 70 caracteres.</div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="comuna">Comuna:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="comuna" name="comuna" class="form-control" required>
                    <div id="comunaError" class="alert alert-danger" role="alert" style="display: none;">La comuna es obligatoria y debe tener un máximo de 50 caracteres.</div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="edad">Edad:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" id="edad" name="edad" class="form-control" required>
                    <div id="edadError" class="alert alert-danger" role="alert" style="display: none;">La edad debe ser un número entero mayor o igual a 0 y menor a 150.</div>
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

    <%@ include file="/views/footer.jsp"%>
    <!-- Inclusión del archivo JSP que contiene el footer -->

    <!-- Agregar el enlace al archivo JS de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Inclusión de jQuery -->

    <script>
        $(document).ready(function() {
            $('#telefono').on('input', function() {
                var telefono = $(this).val();
                if (telefono.trim().length === 0) {
                    $('#telefonoError').show();
                } else {
                    $('#telefonoError').hide();
                }
            });

            $('#afp').on('input', function() {
                var afp = $(this).val();
                if (afp.trim().length < 4 || afp.trim().length > 30) {
                    $('#afpError').show();
                } else {
                    $('#afpError').hide();
                }
            });

            $('#direccion').on('input', function() {
                var direccion = $(this).val();
                if (direccion.trim().length === 0 || direccion.trim().length > 70) {
                    $('#direccionError').show();
                } else {
                    $('#direccionError').hide();
                }
            });

            $('#comuna').on('input', function() {
                var comuna = $(this).val();
                if (comuna.trim().length === 0 || comuna.trim().length > 50) {
                    $('#comunaError').show();
                } else {
                    $('#comunaError').hide();
                }
            });

            $('#edad').on('input', function() {
                var edad = $(this).val();
                if (isNaN(edad) || edad < 0 || edad >= 150) {
                    $('#edadError').show();
                } else {
                    $('#edadError').hide();
                }
            });
        });
    </script>
    <!-- Script para mostrar las alertas en tiempo real -->
</body>

</html>

