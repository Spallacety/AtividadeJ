package br.edu.ifpi.entity;

import javax.persistence.*;

@Entity
public class Participante {

	@Id
	@GeneratedValue
	private int id;
	private String cpf;
	private String nome;
	private String fone;
	private String perfil;
	
	Participante() { }

	public Participante(String cpf, String nome, String fone, String perfil) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
		this.perfil = perfil;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Participante de id " + id + "\nNome: " + nome + "\nCPF: " + cpf
				+ "\nFone: " + fone + "\nPerfil: + " + perfil + "\n\n";
	}
}