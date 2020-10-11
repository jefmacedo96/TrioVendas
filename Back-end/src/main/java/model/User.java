package model;

public class User {
	int id;
	String cpf;
	String senha;
	String name;
	String email;
	String telefone;
	String estado;
	String cidade;
	String complemento;
	
	
	@Override
	public String toString() {
		return "User [id =" + id + ", CPF =" + cpf + ", Senha =" + senha + ",Nome =" + name + ",Email =" + email + ",Telefone =" + telefone + ",estado =" + estado +",cidade =" + cidade+ ",complemento =" + complemento +"]";         
	}
	public User(int id, String cpf, String senha,String name,String email,String telefone,String estado,String cidade,String complemento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
