package edu.fatec.urna.entidades;

import java.io.Serializable;



public class Eleitor implements Serializable{
	
	
	
	private static final long serialVersionUID = -1L;
	private long id;
	private String nome;
	private String titulo;
	private int confirmacao;

	public Eleitor(){}

 
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
	public int getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(int confirmacao) {
		this.confirmacao = confirmacao;
	}
   
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
