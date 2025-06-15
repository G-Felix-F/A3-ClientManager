package br.com.client.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.manager.entity.EnderecoEntity;
import br.com.client.manager.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<EnderecoEntity> listarEnderecos() {
		return enderecoRepository.findAll();
	}

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoEntity> buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnderecoEntity salvarEndereco(@RequestBody EnderecoEntity endereco) {
    	return enderecoRepository.save(endereco);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable Long id) {
        if (enderecoRepository.existsById(id)) {
        	enderecoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
