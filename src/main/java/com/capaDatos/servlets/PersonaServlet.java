package com.capaDatos.servlets;

import com.capaDatos.dao.impl.PersonaDAOImpl;
import com.capaDatos.entidades.Persona;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {

    private PersonaDAOImpl personaDAO;

    @Override
    public void init() {
        personaDAO = new PersonaDAOImpl();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {

            String id = request.getParameter("id");

            if (id != null && !id.isEmpty()) {
                personaDAO.eliminar(Integer.parseInt(id));
            }

            response.sendRedirect(request.getContextPath() + "/personas");
            return;
        }

        if ("editar".equals(accion)) {

            String id = request.getParameter("id");

            if (id != null && !id.isEmpty()) {

                Persona persona =
                        personaDAO.buscarPorId(Integer.parseInt(id));

                request.setAttribute("persona", persona);
            }

            request.getRequestDispatcher(
                    "/WEB-INF/views/persona-form.jsp"
            ).forward(request, response);

            return;
        }

        List<Persona> personas = personaDAO.buscarTodos();

        request.setAttribute("personas", personas);

        request.getRequestDispatcher(
                "/WEB-INF/views/personas.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        if (id == null || id.isEmpty()) {

            Persona persona = new Persona(nombre, apellido);

            personaDAO.insertar(persona);

        } else {

            Persona persona =
                    personaDAO.buscarPorId(Integer.parseInt(id));

            if (persona != null) {

                persona.setNombre(nombre);
                persona.setApellido(apellido);

                personaDAO.actualizar(persona);
            }
        }

        response.sendRedirect(
                request.getContextPath() + "/personas"
        );
    }
}