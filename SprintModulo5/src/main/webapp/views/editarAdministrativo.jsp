<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="sprintmodulo5.modelo.Administrativo"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Editar Administrativo</title>

    <!-- Enlace a hojas de estilo personalizadas -->
    <link rel="stylesheet" href="views/styles.css">

    <!-- Enlace al archivo CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <%@ include file="/views/navbar.jsp"%>

    <div class="h1-container">
        <h1>Editar Administrativo</h1>
    </div>

    <div class="container">
        <form action="EditarAdministrativoServlet" method="post">
            <%-- Obtener el administrativo a editar del atributo "administrativo" --%>
            <%
            Administrativo administrativo = (Administrativo) request.getAttribute("administrativo");
            %>
            <input type="hidden" name="id" value="<%=administrativo.getIdAdministrativo()%>">

            <div class="form-group row">
                <label for="area" class="col-sm-2 col-form-label">Área:</label>
                <div class="col-sm-4">
                    <input type="text" name="area" value="<%=administrativo.getArea()%>" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="experienciaPrevia" class="col-sm-2 col-form-label">Experiencia Previa:</label>
                <div class="col-sm-4">
                    <input type="text" name="experienciaPrevia" value="<%=administrativo.getExperienciaPrevia()%>" class="form-control">
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

