package br.com.tcessin.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcessin.financys.domain.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}

