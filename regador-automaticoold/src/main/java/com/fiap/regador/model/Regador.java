package com.fiap.regador.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Regador {
	
	@Id
	private String id;	
	
	private String info;
	
	private BigDecimal porcentagem;
	
	private Date horario;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	

	
	
	
	

}
