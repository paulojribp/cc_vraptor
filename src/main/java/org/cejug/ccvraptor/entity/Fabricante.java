package org.cejug.ccvraptor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

@Entity
public class Fabricante {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FABRICANTE_SEQ")
	@SequenceGenerator(name="FABRICANTE_SEQ", sequenceName="FABRICANTE_SEQ", allocationSize=1)
	private Long id;
	
	@Column(unique=true)
	@NaturalId
	private String codigo;
	
	private String nome;
	
	private String razaoSocial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}
