package edu.fatec.urna.entidades;

import java.io.Serializable;





public class Funcionario implements Serializable {
	
	
	
	private static final long serialVersionUID = 2L;
	private long id;
	private String usuario;
	private String senha;

	public Funcionario(){}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

   
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
  
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
