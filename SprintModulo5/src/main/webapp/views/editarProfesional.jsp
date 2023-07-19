<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="sprintmodulo5.modelo.Profesional"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Editar Profesional</title>

    <!-- Enlace a hojas de estilo personalizadas -->
    <link rel="stylesheet" href="views/styles.css">

    <!-- Enlace al archivo CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <%@ include file="/views/navbar.jsp"%>

    <div class="h1-container">
        <h1>Editar Profesional</h1>
    </div>

    <div class="container">
        <form action="EditarProfesionalServlet" method="post">
            <%-- Obtener el profesional a editar del atributo "profesional" --%>
            <%
            Profesional profesional = (Profesional) request.getAttribute("profesional");
            %>
            <input type="hidden" name="id" value="<%=profesional.getIdProfesional()%>">

            <div class="form-group row">
                <label for="titulo" class="col-sm-2 col-form-label">Título:</label>
                <div class="col-sm-4">
                    <input type="text" name="titulo" value="<%=profesional.getTitulo()%>" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="fechaIngreso" class="col-sm-2 col-form-label">Fecha de Ingreso:</label>
                <div class="col-sm-4">
                    <input type="text" name="fechaIngreso" value="<%=profesional.getFechaIngreso()%>" class="form-control">
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <input type="submit" value="Guardar" class="btn btn-primary">
                </div>
            </div>
        </form>
    </div>

    <%@ include file="/views/footer.jsp"%>

    <!-- Agregar el enlace al archivo JS de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>

