package com.allangarcia.teste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.allangarcia.teste.repositories.PessoaRepository;
import com.allangarcia.teste.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa consultarPessoasPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}

	private void updateData(Pessoa entity, Pessoa obj) {
		entity.setNome(obj.getNome());
		entity.setDt_nasc(obj.getDt_nasc());

	}

	public Pessoa updateByNome(String nome, Pessoa obj) {
		try {
			Pessoa entity = repository.findByNome(nome);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(nome);
		}
	}

	public List<Endereco> getEnderecosByPessoaName(String nome) {
		Pessoa pessoa = repository.findByNome(nome);
		return pessoa.getEnderecos();
	}
	

	
	public void updateEnderecoPrincipal(String nome, Long id) {
	    Pessoa pessoa = repository.findByNome(nome);
	    List<Endereco> enderecos = pessoa.getEnderecos();
	    for (Endereco endereco : enderecos) {
	      if (endereco.getId().equals(id)) {
	        endereco.setPrincipal(true);
	      } else {
	        endereco.setPrincipal(false);
	      }
	    }
	    repository.save(pessoa);
	  }

}
