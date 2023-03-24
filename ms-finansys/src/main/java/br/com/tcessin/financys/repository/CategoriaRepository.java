package br.com.tcessin.financys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tcessin.financys.domain.Categoria;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
}

