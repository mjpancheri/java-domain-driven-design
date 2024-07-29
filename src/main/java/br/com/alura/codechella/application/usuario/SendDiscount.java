package br.com.alura.codechella.application.usuario;

import br.com.alura.codechella.infrastructure.usuario.Usuario;

public interface SendDiscount {
    void sendTo(Usuario user);
}
