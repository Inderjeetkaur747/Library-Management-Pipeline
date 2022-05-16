package com.training.advancejava.librarymanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.advancejava.librarymanagement.dao.BookRepository;
import com.training.advancejava.librarymanagement.entity.Book;

@Service
public class BookRepositoryServices {
	@Autowired
	BookRepository bookRepository;
	
	public void addBook(Book book) {
		this.bookRepository.save(book);
	}
	
	public List<Book> getAllBook(){
		return (List<Book>)this.bookRepository.findAll();
	}
	
	public Book getBook(int bookId) {
		try {
			Optional<Book> optional = this.bookRepository.findById(bookId);
			return optional.get();
		}catch(Exception e) {
			return new Book();
		}
		
	}
	
	public Book updateBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	public void deleteBook(int bookId) {
		try {
			this.bookRepository.deleteById(bookId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
	
}
