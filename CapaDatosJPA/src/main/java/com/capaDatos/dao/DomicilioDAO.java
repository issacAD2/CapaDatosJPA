package com.capaDatos.dao;

import com.capaDatos.entidades.Domicilio;
import java.util.List;

public interface DomicilioDAO {

    void insertar(Domicilio domicilio);

    Domicilio buscarPorId(Integer id);

    List<Domicilio> buscarTodos();
}