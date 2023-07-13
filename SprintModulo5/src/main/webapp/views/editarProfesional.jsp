<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="sprintmodulo5.modelo.Profesional" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Editar Profesional</title>
</head>

<body>
    <%@ include file="/views/navbar.jsp" %>

    <div class="h1-container">
        <h1>Editar Profesional</h1>
    </div>

    <div class="container">
        <form action="EditarProfesionalServlet" method="post">
            <%-- Obtener el profesional a editar del atributo "profesional" --%>
            <%
            Profesional profesional = (Profesional) request.getAttribute("profesional");
            %>
            <input type="hidden" name="rutProfesional" value="<%=profesional.getRun()%>">

            <div class="form-group">
                <label for="titulo">Título:</label>
                <input type="text" name="titulo" value="<%=profesional.getTitulo()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="fechaIngreso">Fecha de Ingreso:</label>
                <input type="text" name="fechaIngreso" value="<%=profesional.getFechaIngreso()%>" class="form-control">
            </div>

            <input type="submit" value="Guardar" class="btn btn-primary">
        </form>
    </div>

    <%@ include file="/views/footer.jsp" %>

    <!-- Agregar el enlace al archivo JS de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
