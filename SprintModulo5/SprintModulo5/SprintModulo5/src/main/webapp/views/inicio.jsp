<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <title>Proyecto de Prevención de Riesgos</title>
  <!-- Agregar el enlace al archivo CSS de Bootstrap -->
<link rel="stylesheet" href="views/styles.css">
</head>

<body>
  <!-- Barra de navegación -->
  <%@ include file="navbar.jsp" %>

<!-- Aquí va el contenido de la página Inicio -->
  

  <!-- Sección de inicio -->
  <section id="inicio">
    <div class="container">
      <h1>PROYECTO</h1>
      <p>Creación colaborativa del Proyecto "Solución tecnológica para Compañía de Prevención de Riesgos" (en
        adelante, Proyecto o indistintamente, SprintModulo4) para representar lo aprendido en el Módulo 4
        "Fundamentos de Programación en Java" del BootCamp "Desarrollo de Aplicaciones Full Stack Java Trainee
        v2.0" impartido por FUDESCO en el marco de la iniciativa público - privada Talento Digital para Chile,
        impulsada por Fundación Chile y Fundación Kodea.</p>
      <p>El Proyecto tiene como objetivo ofrecer un sistema de prevención de riesgos, completo y a un costo
        económico, permitiéndoles gestionar y administrar los procesos del negocio, tales como el registro de
        PROFESIONALES, CLIENTE, USUARIO, ADMINISTRATIVO, CAPACITACIONES, ACCIDENTES y REVISIONES, así como
        también la coordinación entre estos, mejorando de esta forma la gestión, control, seguridad y
        disponibilidad de la información de las empresas, lo que se refleja en la práctica en un mejor ambiente
        de seguridad laboral, una mejor calidad del servicio, una disminución de las multas, y un seguimiento
        adecuado de los procesos.</p>
    </div>
    <aside>
      <img src="<%= request.getContextPath() %>/views/usuarios_pantallas.jpg" alt="Usuarios en pantallas">
    </aside>
  </section>

  <!-- Footer -->
  <%@ include file="footer.jsp" %>

  <!-- Agregar el enlace al archivo JS de Bootstrap -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>

</html>

