package com.allangarcia.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allangarcia.teste.entities.Endereco;



public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
}
