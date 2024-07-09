package br.com.abps.AvaliacaoAPIRest.controller;

import br.com.abps.AvaliacaoAPIRest.dto.PessoaDTO;
import br.com.abps.AvaliacaoAPIRest.model.Pessoa;
import br.com.abps.AvaliacaoAPIRest.repository.RepositorioPessoa;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class ControllerPessoa {

    @Autowired
    private RepositorioPessoa repositorioPessoa;

    @PostMapping
    @Operation(summary = "Cria uma nova Pessoa")
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return repositorioPessoa.save(pessoa);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de uma Pessoa por ID")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return repositorioPessoa.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/maladireta/{id}")
    @Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
    public ResponseEntity<PessoaDTO> getPessoaMalaDiretaById(@PathVariable Long id) {
        return repositorioPessoa.findById(id)
                .map(pessoa -> {
                    String malaDireta = String.format("%s, %s – CEP: %s – %s/%s",
                            pessoa.getEndereco(), pessoa.getNome(),
                            pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());
                    return ResponseEntity.ok(new PessoaDTO(pessoa.getId(), pessoa.getNome(), malaDireta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Lista todas as Pessoas")
    public List<Pessoa> getAllPessoas() {
        return repositorioPessoa.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma Pessoa existente")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoaDetails) {
        return repositorioPessoa.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaDetails.getNome());
                    pessoa.setEndereco(pessoaDetails.getEndereco());
                    pessoa.setCep(pessoaDetails.getCep());
                    pessoa.setCidade(pessoaDetails.getCidade());
                    pessoa.setUf(pessoaDetails.getUf());
                    Pessoa updatedPessoa = repositorioPessoa.save(pessoa);
                    return ResponseEntity.ok(updatedPessoa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma Pessoa por ID")
    public ResponseEntity<Object> deletePessoa(@PathVariable Long id) {
        return repositorioPessoa.findById(id)
                .map(pessoa -> {
                	repositorioPessoa.delete(pessoa);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

