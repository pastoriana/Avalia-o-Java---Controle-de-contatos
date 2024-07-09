package br.com.abps.AvaliacaoAPIRest.controller;

import br.com.abps.AvaliacaoAPIRest.model.Contato;
import br.com.abps.AvaliacaoAPIRest.model.Pessoa;
import br.com.abps.AvaliacaoAPIRest.repository.RepositorioContato;
import br.com.abps.AvaliacaoAPIRest.repository.RepositorioPessoa;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ControllerContato {

    @Autowired
    private RepositorioContato repositorioContato;

    @Autowired
    private RepositorioPessoa repositorioPessoa;

    @PostMapping
    @Operation(summary = "Adiciona um novo Contato a uma Pessoa")
    public ResponseEntity<Contato> createContato(@RequestBody Contato contato) {
        Pessoa pessoa = repositorioPessoa.findById(contato.getPessoa().getId()).orElse(null);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        contato.setPessoa(pessoa);
        return ResponseEntity.ok(repositorioContato.save(contato));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de um Contato por ID")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        return repositorioContato.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{pessoaId}")
    @Operation(summary = "Lista todos os Contatos de uma Pessoa")
    public List<Contato> getContatosByPessoaId(@PathVariable Long pessoaId) {
        return repositorioContato.findByPessoaId(pessoaId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Contato existente")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody Contato contatoDetails) {
        return repositorioContato.findById(id)
                .map(contato -> {
                    contato.setTipoContato(contatoDetails.getTipoContato());
                    contato.setContato(contatoDetails.getContato());
                    Contato updatedContato = repositorioContato.save(contato);
                    return ResponseEntity.ok(updatedContato);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um Contato por ID")
    public ResponseEntity<Object> deleteContato(@PathVariable Long id) {
        return repositorioContato.findById(id)
                .map(contato -> {
                	repositorioContato.delete(contato);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}