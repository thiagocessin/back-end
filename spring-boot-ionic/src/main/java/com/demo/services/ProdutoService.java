package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Categoria;
import com.demo.domain.Produto;
import com.demo.repositories.ProdutoRepository;
import com.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Produto> findAll() {
		 return repo.findAll();
	}
	
	public Produto save(Produto produto) {
		return repo.save(produto);
	}

}
