package com.training.advancejava.librarymanagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.advancejava.librarymanagement.entity.Author;
import com.training.advancejava.librarymanagement.entity.Book;
import com.training.advancejava.librarymanagement.services.AuthorRepositoryServices;
import  com.training.advancejava.librarymanagement.services.BookRepositoryServices;



@RestController
public class BookAndAuthorController {
	@Autowired
	private BookRepositoryServices bookRepositoryServices;
	
	@Autowired
	private AuthorRepositoryServices authorRepositorySercices;
	
	
//	Curd operations on Book
	
	@PostMapping("/addBook")
	public String addNewBook(@RequestBody Book book) {
		this.bookRepositoryServices.addBook(book);
		return "Inserted";
	}
	
	@GetMapping("/getAllBook")
	public List<Book> getAllBook() {
		return this.bookRepositoryServices.getAllBook();
	}
	
	@GetMapping("/getBook/{bookId}")
	public Book getBook(@PathVariable("bookId") int bookId) {
		return this.bookRepositoryServices.getBook(bookId);
	}
	
	@PutMapping("/updateBook/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		book.setBookCode(bookId);
		return this.bookRepositoryServices.updateBook(book);
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookRepositoryServices.deleteBook(bookId);
	}
	
	
	
	
//	curd operations on author
	
	@PostMapping("/addAuthor")
	public Author addNewAuthor(@RequestBody Author author) {
		return this.authorRepositorySercices.addAuthor(author);
	}
	
	@GetMapping("/getAllAuthor")
	public List<Author> getAllAuthor(){
		return this.authorRepositorySercices.getAllAuthor();
	}
	
	@PutMapping("/updateAuthor/{authorId}")
	public Author updateAuthor(@RequestBody Author author, @PathVariable("authorId") int authorId) {
		return this.authorRepositorySercices.updateAuthor(author, authorId);
	}
	
	@PostMapping("/deleteAuthor/{authorId}")
	public String deleteAuthor(@PathVariable("authorId") int authorId) {
		this.authorRepositorySercices.deleteAuthor(authorId);
		return "deleted";
	}
	

	

}
