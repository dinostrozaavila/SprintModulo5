<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="sprintmodulo5.modelo.Cliente"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>

    <!-- Enlace a hojas de estilo personalizadas -->
    <link rel="stylesheet" href="views/styles.css">

    <!-- Enlace al archivo CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="telefono">Teléfono:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="telefono" value="<%=cliente.getTelefono()%>" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="afp">AFP:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="afp" value="<%=cliente.getAfp()%>" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="sistemaSalud">Sistema de Salud:</label>
                </div>
                <div class="form-group col-md-4">
                    <select id="sistemaSalud" name="sistemaSalud" class="form-control" required>
                        <option value="1" <%=String.valueOf(cliente.getSistemaSalud()).equals("1") ? "selected" : ""%>>Fonasa</option>
                        <option value="2" <%=String.valueOf(cliente.getSistemaSalud()).equals("2") ? "selected" : ""%>>Isapre</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="direccion">Dirección:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="direccion" value="<%=cliente.getDireccion()%>" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="comuna">Comuna:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="comuna" value="<%=cliente.getComuna()%>" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="edad">Edad:</label>
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="edad" value="<%=cliente.getEdad()%>" class="form-control">
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <input type="submit" value="Guardar" class="btn btn-primary">
                </div>
            </div>
        </form>
    </div>

    <% if ("true".equals(request.getAttribute("mostrarVentanaEmergente"))) { %>
        <script>
            alert("Guardado exitoso");
        </script>
    <% } %>

    <%@ include file="/views/footer.jsp"%>

    <!-- Agregar el enlace al archivo JS de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>

