package br.com.carlos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvento;
	
	@Column(length=100)
	private String evento;
	
	@Column(length=100)
	private String endereco;
	
	@Column(length=50)
	private String complemento;
	
	@Column(length=50)
	private String bairro;
	
	@Column(length=50)
	private String cidade;
	
	@Column(length=2)
	private String uf;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario", referencedColumnName= "id")
	@JsonBackReference
	private Usuario usuario;
	
	public Evento(String evento, String endereco, String complemento, String bairro, String cidade, String uf) {
		this.evento = evento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Evento() {
	
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
