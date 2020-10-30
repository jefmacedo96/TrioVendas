package br.ufc.web.triovendas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	int id;
	
	@NotBlank(message = "O nome não pode ser null")
	String nome;
	
	@NotBlank(message = "O email não pode ser null")
	String email;
	
	@NotBlank(message = "Seu cpf deve possuir 11 caracteres")
	@Column(length=11)
	String cpf;
	
	@NotBlank
	@Size(min = 6, message = "Sua senha deve possuir pelo menos 6 caracteres")
	String senha;
	
	@NotBlank(message = "O cargo não pode ser null")
	String cargo;

	public Employee() {
	}

	public Employee(int id, String nome, String email, String cpf, String senha, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
	}

	public Employee(String nome, String email, String cpf, String senha, String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha
				+ ", cargo=" + cargo + "]";
	}
}
