package br.com.tcessin.financys.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	
	public Categoria() {
		
	}

	public Categoria(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.name = nome;
		this.description = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", name=" + name + ", description=" + description + ", lancamentos="
				+ lancamentos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, lancamentos, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(lancamentos, other.lancamentos) && Objects.equals(name, other.name);
	}

	

	
	
	

}
