package com.example.progbibdst.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table (name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String titolo;
	
	@ManyToOne
	@JoinColumn(name = "autore",referencedColumnName = "id", nullable = false)
	private Autore autore;
	
	@Column (nullable = false)
	private String isbn;
	
	@Column (nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date annoPubb;
	
	@Column (nullable = false)
	private String editore;
	
	@Column (nullable = false)
	private String genere;
	
	
	
}
