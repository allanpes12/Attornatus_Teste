package com.allangarcia.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.allangarcia.teste.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco insertEnderecoPrincipal(Endereco endereco, Pessoa pessoa, boolean principal) {
		if (principal) {
			List<Endereco> enderecos = pessoa.getEnderecos();
			for (Endereco end : enderecos) {
				if (end.getPrincipal()) {
					end.setPrincipal(false);
					repository.save(end);
					break;
				}
			}
			endereco.setPrincipal(true);
		}
		endereco.setPessoa(pessoa);
		return repository.save(endereco);
	}

	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
}
