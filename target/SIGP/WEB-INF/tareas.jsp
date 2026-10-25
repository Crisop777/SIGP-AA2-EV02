<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>SIGP | Tareas registradas</title>
  <style>
    body{font-family:Arial,sans-serif;background:#f3f6fb;margin:0;color:#172033}
    main{max-width:760px;margin:50px auto;padding:28px;background:white;border-radius:14px;box-shadow:0 5px 22px #0001}
    h1{color:#173b70}.item{padding:13px;background:#eef3fa;border-radius:7px;margin:9px 0}
    a{color:#174a85}
  </style>
</head>
<body>
<main>
  <h1>Tareas de SIGP</h1>
  <p>Consulta procesada mediante el método <strong><%= request.getAttribute("metodoUsado") %></strong>.</p>
  <%
    String mensaje = (String) session.getAttribute("mensaje");
    if (mensaje != null) {
  %>
    <p><strong><%= mensaje.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;") %></strong></p>
  <%
      session.removeAttribute("mensaje");
    }
    List<String> tareas = (List<String>) request.getAttribute("tareas");
    if (tareas == null || tareas.isEmpty()) {
  %>
    <p>Aún no hay tareas registradas. Regresa al formulario para crear la primera.</p>
  <%
    } else {
      for (String tarea : tareas) {
        String seguro = tarea.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                             .replace("\"", "&quot;").replace("'", "&#39;");
  %>
    <div class="item"><%= seguro %></div>
  <%
      }
    }
  %>
  <p><a href="index.html">← Volver al formulario</a></p>
  <p><a href="tareas?origen=consulta">Actualizar listado (GET)</a></p>
</main>
</body>
</html>
