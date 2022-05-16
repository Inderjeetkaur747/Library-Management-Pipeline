package com.training.advancejava.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.advancejava.librarymanagement.dao.AuthorRepository;
import com.training.advancejava.librarymanagement.entity.Author;

@Service
public class AuthorRepositoryServices {
	@Autowired
	AuthorRepository authorRepository;
	
	
	public Author addAuthor(Author author) {
		return this.authorRepository.save(author);
	}
	
	public List<Author> getAllAuthor(){
		return (List<Author>)this.authorRepository.findAll();
	}
	
	public Author updateAuthor(Author author, int id) {
		author.setAuthorId(id);
		return this.authorRepository.save(author);
	}
	
	public void deleteAuthor(int id) {
		this.authorRepository.deleteById(id);
	}
}
