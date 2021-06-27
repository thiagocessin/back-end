package com.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Produto;
import com.demo.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Produto produto) {
		return ResponseEntity.ok(service.save(produto));
	}

}
