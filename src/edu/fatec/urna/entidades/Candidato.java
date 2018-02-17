package edu.fatec.urna.entidades;



import java.io.Serializable;



public class Candidato implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String partido;
	private int numero;
	private int voto;

	public Candidato(){}
	
	

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

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
}
