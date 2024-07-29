package br.com.alura.codechella;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public DadosEvento cadastrarEvento(DadosCadastroEvento dadosCadastro) {
        var evento = new Evento(dadosCadastro);
        repository.save(evento);
        return converteDados(evento);
    }

    public List<DadosEvento> listarTodos() {
        List<Evento> eventos = repository.findAll();
        return eventos.stream()
                .map(this::converteDados)
                .toList();
    }

    private DadosEvento converteDados(Evento evento) {
        List<DadosCadastroTipoIngresso> dadosIngressos = evento.getTipoIngressos().stream()
                .map(i -> new DadosCadastroTipoIngresso(i.getSetor(), i.getDefinicao(),
                        i.getValor(), i.getTotalDisponivel()))
                .toList();

        return new DadosEvento(evento.getId(), evento.getCategoria(),
                evento.getDescricao(), new DadosEndereco(evento.getEndereco().getCep(),
                evento.getEndereco().getNumero(), evento.getEndereco().getComplemento()),
                evento.getData(), dadosIngressos);

    }
}
