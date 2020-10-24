package br.ufc.web.aula17.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue
	int id;
	String cpf;
	String senha;
	String nome;
	String email;
	String telefone;
	String estado;
	String cidade;
	String complemento;

	public User() {
	}

	public User(int id, String cpf, String senha, String nome, String email, String telefone, String estado,
			String cidade, String complemento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.complemento = complemento;
	}

	public User(String cpf, String senha, String nome, String email, String telefone, String estado, String cidade,
			String complemento) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cpf=" + cpf + ", senha=" + senha + ", nome=" + nome + ", email=" + email
				+ ", telefone=" + telefone + ", estado=" + estado + ", cidade=" + cidade + ", complemento="
				+ complemento + "]";
	}

}
