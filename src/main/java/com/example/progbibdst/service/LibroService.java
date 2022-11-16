package com.example.progbibdst.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progbibdst.model.Autore;
import com.example.progbibdst.model.Libro;
import com.example.progbibdst.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository repo;
	
	
	public List<Libro> getByGenere (String genere) {
		return repo.findByGenere(genere);
	}
	
	public List<Libro> getByAnno (Date annoPubb) {
		return repo.findAllbyAnno(annoPubb);
	}
	
	
	public List<Libro> getAll() {
		return repo.findAll();
	}
	
	public List<Libro> getByAutore(Autore autore) {
		return repo.findByAutore(autore);
	}
		
	
}
