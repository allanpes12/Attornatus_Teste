package com.allangarcia.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allangarcia.teste.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNomeContainingIgnoreCase(String nome);

	Pessoa findByNome(String nome);

}
