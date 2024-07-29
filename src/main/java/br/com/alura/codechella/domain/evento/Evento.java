package br.com.alura.codechella.domain.evento;

import br.com.alura.codechella.Categoria;
import br.com.alura.codechella.domain.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {

    private Categoria categoria;
    private String descricao;
    private LocalDateTime data;
    private Endereco local;
    private final List<TipoIngresso> tiposIngresso = new ArrayList<>();

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Endereco getLocal() {
        return local;
    }

    public List<TipoIngresso> getTiposIngresso() {
        return tiposIngresso;
    }

    public void addTipoIngresso(TipoIngresso tipoIngresso) {
        this.tiposIngresso.add(tipoIngresso);
    }
}
