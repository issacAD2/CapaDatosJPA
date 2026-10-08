<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.capaDatos.entidades.Persona" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Personas - Capa de Datos</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 30px;
        }

        .contenedor {
            max-width: 900px;
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

        .boton-agregar {
            display: inline-block;
            background: #198754;
            color: white;
            padding: 10px 16px;
            text-decoration: none;
            border-radius: 6px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background: #212529;
            color: white;
        }

        .editar {
            background: #0d6efd;
            color: white;
            padding: 7px 12px;
            text-decoration: none;
            border-radius: 5px;
        }

        .eliminar {
            background: #dc3545;
            color: white;
            padding: 7px 12px;
            text-decoration: none;
            border-radius: 5px;
        }

        .vacio {
            text-align: center;
            padding: 25px;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <h1>Gestión de Personas</h1>

    <a class="boton-agregar"
       href="<%= request.getContextPath() %>/personas?accion=editar">
        + Agregar Persona
    </a>

    <table>

        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Acciones</th>
        </tr>
        </thead>

        <tbody>

        <%
            List<Persona> personas =
                    (List<Persona>) request.getAttribute("personas");

            if (personas != null && !personas.isEmpty()) {

                for (Persona persona : personas) {
        %>

        <tr>

            <td>
                <%= persona.getIdPersona() %>
            </td>

            <td>
                <%= persona.getNombre() %>
            </td>

            <td>
                <%= persona.getApellido() %>
            </td>

            <td>

                <a class="editar"
                   href="<%= request.getContextPath() %>/personas?accion=editar&id=<%= persona.getIdPersona() %>">
                    Editar
                </a>

                <a class="eliminar"
                   href="<%= request.getContextPath() %>/personas?accion=eliminar&id=<%= persona.getIdPersona() %>"
                   onclick="return confirm('¿Seguro que deseas eliminar esta persona?');">
                    Eliminar
                </a>

            </td>

        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="4" class="vacio">
                No hay personas registradas.
            </td>
        </tr>

        <%
            }
        %>

        </tbody>

    </table>

</div>

</body>
</html>