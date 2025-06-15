package br.com.client.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.client.manager.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
