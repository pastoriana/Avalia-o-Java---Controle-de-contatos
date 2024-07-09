package br.com.abps.AvaliacaoAPIRest.repository;

import br.com.abps.AvaliacaoAPIRest.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioContato extends JpaRepository<Contato, Long> {
    List<Contato> findByPessoaId(Long pessoaId);
}

