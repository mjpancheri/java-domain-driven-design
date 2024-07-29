package br.com.alura.codechella.domain.evento;

import br.com.alura.codechella.domain.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {

    private UUID id;
    private Categoria categoria;
    private String descricao;
    private LocalDateTime data;
    private Endereco endereco;
    private final List<TipoIngresso> tiposIngresso = new ArrayList<>();

    private Evento() {
    }

    private void gerarIdentificadorUnico() {
        this.id = UUID.randomUUID();
    }

    public void incluiNovoTipoDeIngressoAoEvento(TipoIngresso tipoIngresso){
        this.tiposIngresso.add(tipoIngresso);
    }

    public void aumentaNumeroDeIngressosPorTipo() {
        //implementar aqui
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<TipoIngresso> getTiposIngresso() {
        return tiposIngresso;
    }

    public void addTipoIngresso(TipoIngresso tipoIngresso) {
        this.tiposIngresso.add(tipoIngresso);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "categoria=" + categoria +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", data=" + data +
                '}';
    }

    public static class Builder {
        private final Evento evento;

        public Builder() {
            evento = new Evento();
        }

        public Builder comCategoria(Categoria categoria) {
            evento.categoria = categoria;
            return this;
        }

        public Builder comDescricao(String descricao) {
            evento.descricao = descricao;
            return this;
        }

        public Builder comEndereco(String cep, Integer numero, String complemento) {
            evento.endereco = new Endereco(cep, numero, complemento);
            return this;
        }

        public Builder comData(LocalDateTime data) {
            evento.data = data;
            return this;
        }

        public Evento build() {
            evento.gerarIdentificadorUnico();
            return evento;
        }
    }
}
