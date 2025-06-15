package br.com.client.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.client.manager.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

}
