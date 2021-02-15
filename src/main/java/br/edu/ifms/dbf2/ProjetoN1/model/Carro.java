package br.edu.ifms.dbf2.ProjetoN1.model;

import java.io.Serializable;

public class Carro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String placa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
		
}
