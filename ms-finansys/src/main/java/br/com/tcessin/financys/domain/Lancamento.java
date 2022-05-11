package br.com.tcessin.financys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.tcessin.financys.enums.StatusLancamento;
import br.com.tcessin.financys.enums.TipoLancamento;

@Entity
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer tipo;
	
	private String nome;
	
	private Double valor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	private String descricao;
	
	private Integer status;
	
	
	public Lancamento(Long id, TipoLancamento tipo, String nome, Double valor, Date data, Categoria categoria,
			String descricao, StatusLancamento status) {
		super();
		this.id = id;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.nome = nome;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
		this.descricao = descricao;
		this.status = (status == null) ? null : status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoLancamento getTipo() {
		return TipoLancamento.toEnum(tipo);
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo.getCod();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusLancamento getStatus() {
		return StatusLancamento.toEnum(status);
	}

	public void setStatus(StatusLancamento status) {
		this.status = status.getCod();
	}
	
	
	
	
	
	
	
	
	
}
