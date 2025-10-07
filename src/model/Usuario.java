package model;

public class Usuario {

	private String senha;
	private String nome;
	private String email;

	public Usuario() {
	}
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.email = senha;
	}

	public String getsenha() {
		return senha;
	}

	public String getnome() {
		return nome;
	}

	public String getemail() {
		return email;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public void setemail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", nome=" + nome + ", email=" + email + "]";
	}
}
