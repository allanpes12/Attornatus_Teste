package com.allangarcia.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.allangarcia.teste.services.PessoaService;

@RestController
@RequestMapping(value = "/api")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	// Busca todas as pessoas
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// busca uma pessoa por nome exato
	@GetMapping(value = "/pessoa/{nome}")
	public ResponseEntity<Pessoa> consultarPessoasPorNome(@PathVariable String nome) {
		Pessoa obj = service.consultarPessoasPorNome(nome);
		return ResponseEntity.ok().body(obj);
	}

	// busca endereços da pessoa
	@GetMapping("/pessoa/{nome}/enderecos")
	public List<Endereco> getEderecosByPessoaNome(@PathVariable String nome) {
		return service.getEnderecosByPessoaName(nome);
	}



	// cria uma nova pessoa
	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	// edita uma pessoa por nome
	@PutMapping(value = "/pessoa/{nome}")
	public ResponseEntity<Pessoa> update(@PathVariable String nome, @RequestBody Pessoa obj) {
		obj = service.updateByNome(nome, obj);
		return ResponseEntity.ok().body(obj);
	}

	// edita endereço principal
	@PutMapping("/pessoa/{nome}/enderecos/{id}/principal")
	public ResponseEntity<Void> updateEnderecoPrincipal(@PathVariable String nome, @PathVariable Long id) {
		service.updateEnderecoPrincipal(nome, id);
		return ResponseEntity.noContent().build();
	}
}
