package com.capaDatos.dao;

import com.capaDatos.entidades.Usuario;
import java.util.List;

public interface UsuarioDAO {

    void insertar(Usuario usuario);

    Usuario buscarPorId(Integer id);

    List<Usuario> buscarTodos();
}