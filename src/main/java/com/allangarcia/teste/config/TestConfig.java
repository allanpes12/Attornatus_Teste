package com.allangarcia.teste.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.allangarcia.teste.repositories.EnderecoRepository;
import com.allangarcia.teste.repositories.PessoaRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Allan Garcia", "14/02/1995");
		Pessoa p2 = new Pessoa(null, "Ana Flavia", "14/02/1997");
		Pessoa p3 = new Pessoa(null, "Leandro Ferreira", "14/02/1998");

		Endereco e1 = new Endereco(null, "Rua 1", "78726000", 10, "Rondonopolis", true, p1);
		Endereco e2 = new Endereco(null, "Rua 2", "78726000", 11, "Primavera", true, p2);
		Endereco e3 = new Endereco(null, "Rua 3", "78726000", 12, "Cuiaba", true, p3);

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		
	}

}
