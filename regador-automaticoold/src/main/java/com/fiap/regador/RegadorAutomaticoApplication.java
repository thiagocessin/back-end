package com.fiap.regador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fiap.regador.model.Regador;
import com.fiap.regador.service.RegadorService;

@SpringBootApplication
public class RegadorAutomaticoApplication implements CommandLineRunner{

	@Autowired
	private RegadorService service;
	
	public static void main(String[] args) {
		SpringApplication.run(RegadorAutomaticoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//s3Service.uploadFile("D:\\Thiago\\temp\\img1.jpg");
		
		List<Regador> listar = this.service.listar();
		
		System.out.println(listar);
	}
	
	

}
