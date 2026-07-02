package br.com.oficinapro.repository;

import br.com.oficinapro.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Long>{
}