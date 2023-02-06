package com.allangarcia.teste.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dt_nasc;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	
	public Pessoa() {
		
	}
	
	public Pessoa(Long id, String nome, String dt_nasc) {
		super();
		DateTimeFormatter  formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dt_nasc, formato); 
		
		this.id = id;
		this.nome = nome;
		this.dt_nasc = data;
	}
	
	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	

}
