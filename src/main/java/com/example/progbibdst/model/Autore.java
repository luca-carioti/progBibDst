package com.example.progbibdst.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Autore")
public class Autore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@Column (name = "cognome", nullable = false)
	private String cognome;
	
	@Column (name = "annoNascita", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date annoNascita;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column (name = "annoMorte", nullable = true)
	private Date annoMorte;
	
  //	@OneToMany(mappedBy = "autore")
  //  private List<Libro> libri; 
	
	public Autore() {
		
	}

	public Autore(Integer id, String nome, String cognome, Date annoNascita) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.annoMorte = null;
	}
	
	public Autore(Integer id, String nome, String cognome, Date annoNascita, Date annoMorte) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.annoMorte = annoMorte;
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



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public Date getAnnoNascita() {
		return annoNascita;
	}



	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}



	public Date getAnnoMorte() {
		return annoMorte;
	}



	public void setAnnoMorte(Date annoMorte) {
		this.annoMorte = annoMorte;
	}

	@Override
	public String toString() {
		return "" + nome + " " + cognome;
	}
	
	
	
}

