package com.teste;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.allangarcia.teste.AttornatusTesteApplication;
import com.allangarcia.teste.entities.Endereco;
import com.allangarcia.teste.entities.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = AttornatusTesteApplication.class)
@SpringBootTest(classes = AttornatusTesteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteAtternatusApplicationTests {

	/*@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test // criar uma pessoa
	public void testCreatePessoa() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Allan Garcia");
		pessoa.setDt_nasc(LocalDate.of(1980, 1, 1));

		mockMvc.perform(
				post("/api").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(pessoa)))
				.andExpect(status().isCreated());
	}

	@Test // Editar uma pessoa
	public void testUpdatePessoa() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ana Paula");
		pessoa.setDt_nasc(LocalDate.of(1985, 5, 5));

		MvcResult result = mockMvc.perform(
				post("/api").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(pessoa)))
				.andExpect(status().isCreated()).andReturn();

		String responseString = result.getResponse().getContentAsString();
		Pessoa criaPessoa = objectMapper.readValue(responseString, Pessoa.class);

		pessoa.setNome(criaPessoa.getNome());
		pessoa.setNome("Ana Paula Updated");

		mockMvc.perform(put("/api/pessoa/" + criaPessoa.getNome()).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(pessoa))).andExpect(status().isOk());
	}

	@Test // consultar uma pessoa
	public void testGetPessoa() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos Soares");
		pessoa.setDt_nasc(LocalDate.of(1980, 1, 1));

		MvcResult result = mockMvc.perform(
				post("/api").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(pessoa)))
				.andExpect(status().isCreated()).andReturn();

		String responseString = result.getResponse().getContentAsString();
		Pessoa criaPessoa = objectMapper.readValue(responseString, Pessoa.class);

		mockMvc.perform(get("/api/pessoa/" + criaPessoa.getNome())).andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value(criaPessoa.getNome()))
				.andExpect(jsonPath("$.dt_nasc").value(criaPessoa.getDt_nasc().toString()));
	}

	@Test // Listar pessoas
	public void testGetAllPessoas() throws Exception {
		mockMvc.perform(get("/api/pessoas")).andExpect(status().isOk());
	}

	@Test // Criar endereço para uma pessoa e informar se é principal
	public void testCreateEndereco() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Castro Soares");
		pessoa.setDt_nasc(LocalDate.of(1980, 1, 1));

		MvcResult result = mockMvc.perform(
				post("/api").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(pessoa)))
				.andExpect(status().isCreated()).andReturn();

		String responseString = result.getResponse().getContentAsString();
		Pessoa criaPessoa = objectMapper.readValue(responseString, Pessoa.class);

		Endereco endereco = new Endereco();
		endereco.setLogradouro("av campos");
		endereco.setCep("12345");
		endereco.setNumero(123);
		endereco.setCidade("roo");
		endereco.setPrincipal(true);
		endereco.setPessoa(criaPessoa);

		mockMvc.perform(post("/Castro Soares/novoEndereco").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(endereco))).andExpect(status().isCreated());
	}*/

}
