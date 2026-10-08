package com.capaDatos.dao;

import com.capaDatos.entidades.Persona;
import java.util.List;

public interface PersonaDAO {

    void insertar(Persona persona);

    Persona buscarPorId(Integer id);

    List<Persona> buscarTodos();

    void actualizar(Persona persona);

    void eliminar(Integer id);
}