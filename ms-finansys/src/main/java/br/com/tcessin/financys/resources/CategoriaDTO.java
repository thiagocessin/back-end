package br.com.tcessin.financys.resources;

import java.io.Serializable;

import br.com.tcessin.financys.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Categoria obj) {

		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();

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

}
