package com.example.progbibdst.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.progbibdst.model.Autore;
import com.example.progbibdst.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	List<Libro> findByGenere(String genere);

	List<Libro> findByAnnoPubb(Date AnnoPubb);

//	@Query(
//
//	"select l from Libro l inner join Autore a where l.autore = a.id"
//	
//			)

	List<Libro> findByAutore(Autore autore);
	
	@Modifying
	@Query ("update Libro set autore = ?1, titolo = ?2, isbn = ?3, annoPubb = ?4, editore = ?5, genere = ?6 "
			+ "where id = ?7 ")
	public void update (Integer idAutore, String titolo, String isbn, Date annoPubb, String editore, String genere, Integer id);

}
