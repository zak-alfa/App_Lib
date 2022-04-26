package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Livre;

import com.example.demo.repo.LivreRepo;

import antlr.collections.List;

@Service
public class LivreService {
	
	@Autowired
	LivreRepo repo;
	
 	public List listAll(){
		return (List) repo.findAll();
	}
	public void save(Livre lvr) {
		repo.save(lvr);
	}
    public Livre get (long id) {
    	return repo.findById(id).get();

    }
    public void delete(long id) {
    	repo.deleteById(id);
    }
    public Livre create(Livre livre) {
    	return repo.save(livre);
    }
}