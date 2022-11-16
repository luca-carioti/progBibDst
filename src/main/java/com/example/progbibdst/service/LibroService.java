package com.example.progbibdst.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		return repo.findByAnnoPubb(annoPubb);
	}
	
	@SuppressWarnings("deprecation")
	public Libro getById(Integer id) {
		
		return repo.getOne(id);
	}
	
	
	public List<Libro> getAll() {
		return repo.findAll();
	}
	
	public List<Libro> getByAutore(Autore autore) {
		return repo.findByAutore(autore);
	}
		
	public void delete (Integer id) {
		repo.deleteById(id);
	}
	
	public void update(Libro libro) {
		repo.update(libro.getAutore().getId(), libro.getTitolo(), libro.getIsbn(), libro.getAnnoPubb(), libro.getEditore(), libro.getGenere(), libro.getId());
	}
	
	public Libro add(Libro libro) {
		return repo.save(libro);
		
	}

	public Optional<Libro> findById(Integer id) {
		return repo.findById(id);
	}

	
	
	
}
