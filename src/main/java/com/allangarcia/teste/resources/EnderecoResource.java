package com.allangarcia.teste.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.allangarcia.teste.services.EnderecoService;
import com.allangarcia.teste.services.PessoaService;

@RestController

public class EnderecoResource {

	@Autowired
	private EnderecoService service;

	@Autowired
	private PessoaService pservice;

	@PostMapping("/{nome}/novoEndereco")
	public ResponseEntity<Endereco> criaEnder(@PathVariable String nome, @RequestBody Endereco obj) {

		Pessoa pessoa = pservice.consultarPessoasPorNome(nome);
		obj.setPessoa(pessoa);

		obj = service.insertEnderecoPrincipal(obj, pessoa, obj.getPrincipal());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
