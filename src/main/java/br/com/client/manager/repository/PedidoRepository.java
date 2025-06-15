package br.com.client.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.client.manager.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

}
