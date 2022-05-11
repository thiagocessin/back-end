package br.com.tcessin.financys.services;

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
		return repo.findAll();
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
		return new Categoria(dto.getId(), dto.getNome(), dto.getDescricao());
	}
}
