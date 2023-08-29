package senacdw20232eliezerbackend.exemplodw.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	
	@JsonBackReference
    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtos;

    public Fabricante() {
		super();
	}

	public Fabricante(Integer id, String nome, String cnpj, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
		this.cnpj = cnpj;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
