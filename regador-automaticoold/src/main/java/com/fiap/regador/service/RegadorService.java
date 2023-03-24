package com.fiap.regador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.regador.model.Regador;
import com.fiap.regador.repository.RegadorRepository;

@Service
public class RegadorService {

	
	@Autowired
	private RegadorRepository repo;
	
	
	public List<Regador> listar() {
		return repo.findAll();
	}
	
}
