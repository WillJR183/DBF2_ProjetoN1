package br.edu.ifms.dbf2.ProjetoN1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Infracao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private Long pontos;
	private double valor;

	@OneToMany(mappedBy = "infracao", cascade = CascadeType.ALL)
	private List<Multa> multas = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getPontos() {
		return pontos;
	}
	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	
}