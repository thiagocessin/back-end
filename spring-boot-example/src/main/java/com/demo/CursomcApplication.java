package com.demo;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.domain.Categoria;
import com.demo.domain.Cidade;
import com.demo.domain.Cliente;
import com.demo.domain.Endereco;
import com.demo.domain.Estado;
import com.demo.domain.Produto;
import com.demo.domain.enums.TipoCliente;
import com.demo.repositories.CategoriaRepository;
import com.demo.repositories.CidadeRepository;
import com.demo.repositories.ClienteRepository;
import com.demo.repositories.EnderecoRepository;
import com.demo.repositories.EstadoRepository;
import com.demo.repositories.ProdutoRepository;
import com.demo.services.CidadeService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//executa alguma ação quando a aplicação inicia
	//usando MySql executar somente uma vez para carga na tabela
	@Override
	public void run(String... args) throws Exception {
		//carregaCategoriasProdutos();
		//carregarCidadesEstados();
		//carregarClienteEnderecosTelefones();
	}
	
	
	public void carregarClienteEnderecosTelefones() {
		
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "11238837635", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345678","76767667"));
		
		Cidade cidade1 = cidadeService.find(1);
		Cidade cidade2 = cidadeService.find(2);
		
		Endereco e1 = new Endereco(null,"Rua Flores", "300", "Apto 303", "Jardim", "38383863", cli1, cidade1);
		Endereco e2 = new Endereco(null,"Av Matos", "105", "Sala 800", "Centro", "45443863", cli1, cidade2);

		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}
	
	public void carregarCidadesEstados() {
	
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	
		
	}
	
	public void carregaCategoriasProdutos() {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		
		Produto p1 = new Produto("Computador",2000.00);
		Produto p2 = new Produto("Impressora",800.00);
		Produto p3 = new Produto("Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		

	}


}
