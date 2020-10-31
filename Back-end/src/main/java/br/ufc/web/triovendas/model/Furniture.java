package br.ufc.web.triovendas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "furnitures")
public class Furniture {
	
	@Id
	@GeneratedValue
	int id;
	
	String nome;
	
	String descricao;
	
	String serie;
	
	String tipo;
	
	String preco;
	
	String quantidade;
	
	public Furniture() {
	}
	
	public Furniture(String nome, String descricao, String serie, String tipo, String preco,
			String quantidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.serie = serie;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Furniture(int id, String nome, String descricao, String serie, String tipo, String preco,
			String quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.serie = serie;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "Furniture [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", serie=" + serie + ", tipo="
				+ tipo + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}

}
