package br.com.oficinapro.service;

import br.com.oficinapro.model.Servico;
import br.com.oficinapro.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Servico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Servico salvar(Servico servico) {
        return repository.save(servico);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}