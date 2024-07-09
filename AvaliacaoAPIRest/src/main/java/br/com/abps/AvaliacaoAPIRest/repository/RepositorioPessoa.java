package br.com.abps.AvaliacaoAPIRest.repository;

import br.com.abps.AvaliacaoAPIRest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {
}
