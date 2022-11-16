package com.example.progbibdst.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.progbibdst.model.Autore;
import com.example.progbibdst.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	List<Libro> findByGenere(String genere);

	List<Libro> findAllbyAnno(Date AnnoPubb);

//	@Query(
//
//	"select l from Libro l inner join Autore a where l.autore = a.id"
//	
//			)

	List<Libro> findByAutore(Autore autore);

}
