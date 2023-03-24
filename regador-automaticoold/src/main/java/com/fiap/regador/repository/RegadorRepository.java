package com.fiap.regador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.regador.model.Regador;

public interface RegadorRepository extends MongoRepository<Regador, String> {

}
