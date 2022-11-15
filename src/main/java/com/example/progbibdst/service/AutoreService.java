package com.example.progbibdst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progbibdst.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository repo;
}
