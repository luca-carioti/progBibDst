package com.example.progbibdst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progbibdst.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository repo;
}
