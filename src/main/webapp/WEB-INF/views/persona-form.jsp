<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.capaDatos.entidades.Persona" %>

<%
    Persona persona = (Persona) request.getAttribute("persona");
    boolean editar = persona != null;
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>
        <%= editar ? "Editar Persona" : "Agregar Persona" %>
    </title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 30px;
        }

        .contenedor {
            max-width: 500px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input {
            width: 100%;
            box-sizing: border-box;
            padding: 11px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        button {
            width: 100%;
            margin-top: 25px;
            padding: 12px;
            border: none;
            border-radius: 6px;
            background: #198754;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .volver {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #0d6efd;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <h1>
        <%= editar ? "Editar Persona" : "Agregar Persona" %>
    </h1>

    <form method="post"
          action="<%= request.getContextPath() %>/personas">

        <% if (editar) { %>

            <input type="hidden"
                   name="id"
                   value="<%= persona.getIdPersona() %>">

        <% } %>

        <label for="nombre">Nombre:</label>

        <input type="text"
               id="nombre"
               name="nombre"
               value="<%= editar ? persona.getNombre() : "" %>"
               required>

        <label for="apellido">Apellido:</label>

        <input type="text"
               id="apellido"
               name="apellido"
               value="<%= editar ? persona.getApellido() : "" %>"
               required>

        <button type="submit">
            <%= editar ? "Guardar cambios" : "Agregar persona" %>
        </button>

    </form>

    <a class="volver"
       href="<%= request.getContextPath() %>/personas">
        ← Volver a personas
    </a>

</div>

</body>
</html>