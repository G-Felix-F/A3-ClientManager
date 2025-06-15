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

import br.com.client.manager.entity.PedidoEntity;
import br.com.client.manager.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<PedidoEntity> listarPedidos() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoEntity> buscarPedidoPorId(@PathVariable Long id) {
		return pedidoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
    public PedidoEntity salvarPedido(@RequestBody PedidoEntity pedido) {
    	return pedidoRepository.save(pedido);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
        	pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
