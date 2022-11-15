package com.example.progbibdst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progbibdst.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
