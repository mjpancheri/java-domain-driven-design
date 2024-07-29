package br.com.alura.codechella.application.evento;

import br.com.alura.codechella.domain.evento.Evento;

import java.util.List;

public interface RepositoryOfEvento {

    List<Evento> findByCep(String cep);
}
