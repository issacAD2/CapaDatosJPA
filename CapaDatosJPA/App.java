package com.capaDatos;

import com.capaDatos.dao.impl.PersonaDAOImpl;
import com.capaDatos.dao.impl.UsuarioDAOImpl;
import com.capaDatos.dao.impl.DomicilioDAOImpl;
import com.capaDatos.entidades.Persona;
import com.capaDatos.entidades.Usuario;
import com.capaDatos.entidades.Domicilio;

public class App {

    public static void main(String[] args) {

        PersonaDAOImpl personaDAO = new PersonaDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        DomicilioDAOImpl domicilioDAO = new DomicilioDAOImpl();

        System.out.println("========== PERSONAS ==========");
        System.out.println("ID | NOMBRE | APELLIDO");

        for (Persona persona : personaDAO.buscarTodos()) {

            System.out.println(
                    persona.getIdPersona() + " | " +
                    persona.getNombre() + " | " +
                    persona.getApellido()
            );
        }

        System.out.println("\n========== BUSCAR PERSONA POR ID ==========");

        Persona persona = personaDAO.buscarPorId(1);

        if (persona != null) {

            System.out.println(
                    persona.getIdPersona() + " | " +
                    persona.getNombre() + " | " +
                    persona.getApellido()
            );

        } else {

            System.out.println("Persona no encontrada");
        }

        System.out.println("\n========== USUARIOS ==========");
        System.out.println("ID | USUARIO");

        for (Usuario usuario : usuarioDAO.buscarTodos()) {

            System.out.println(
                    usuario.getIdUsuario() + " | " +
                    usuario.getUsuario()
            );
        }

        System.out.println("\n========== BUSCAR USUARIO POR ID ==========");

        Usuario usuario = usuarioDAO.buscarPorId(1);

        if (usuario != null) {

            System.out.println(
                    usuario.getIdUsuario() + " | " +
                    usuario.getUsuario()
            );

        } else {

            System.out.println("Usuario no encontrado");
        }

        System.out.println("\n========== DOMICILIOS ==========");
        System.out.println("ID | CALLE | NUMERO | COLONIA");

        for (Domicilio domicilio : domicilioDAO.buscarTodos()) {

            System.out.println(
                    domicilio.getIdDomicilio() + " | " +
                    domicilio.getCalle() + " | " +
                    domicilio.getNumero() + " | " +
                    domicilio.getColonia()
            );
        }

        System.out.println("\n========== BUSCAR DOMICILIO POR ID ==========");

        Domicilio domicilio = domicilioDAO.buscarPorId(1);

        if (domicilio != null) {

            System.out.println(
                    domicilio.getIdDomicilio() + " | " +
                    domicilio.getCalle() + " | " +
                    domicilio.getNumero() + " | " +
                    domicilio.getColonia()
            );

        } else {

            System.out.println("Domicilio no encontrado");
        }

        System.out.println("\n========== PROGRAMA FINALIZADO ==========");
    }
}