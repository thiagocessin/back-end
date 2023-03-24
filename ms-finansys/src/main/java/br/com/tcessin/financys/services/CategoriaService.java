package br.com.tcessin.financys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcessin.financys.domain.Categoria;
import br.com.tcessin.financys.repository.CategoriaRepository;
import br.com.tcessin.financys.resources.CategoriaDTO;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> findAll() {

		List<Categoria> lista = new ArrayList<>();

		repo.findAll().forEach(lista::add);

		return lista;
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria find(Long id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Erro ao recuperar categoria por ID"));
	}
	

	public Categoria fromDTO(CategoriaDTO dto) {
		return new Categoria(dto.getId(), dto.getName(), dto.getDescription());
	}
	
	public void delete(Categoria categoria) {
		repo.delete(categoria);
	}

	public void update(Categoria obj) {
		
	}

	public void update(Categoria obj, CategoriaDTO categoriaNew) {
		
		obj.setName(categoriaNew.getName());
		obj.setDescription(categoriaNew.getDescription());
		
		repo.save(obj);
		
	}
	
}
