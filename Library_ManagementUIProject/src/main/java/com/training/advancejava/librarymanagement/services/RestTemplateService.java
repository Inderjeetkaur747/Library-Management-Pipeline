package com.training.advancejava.librarymanagement.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.advancejava.librarymanagement.entities.Author;
import com.training.advancejava.librarymanagement.entities.Book;


@Service
public class RestTemplateService {
	
	@Autowired
	   RestTemplate restTemplate;
	
	public boolean addBookRestTemplate(Book book) {
		
		Book b=getBookByIdRestTemplate(book.getBookCode());
		if(b.getBookCode()!=0) {
			return false;
		}
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    book.setBookDate(LocalDate.now());
	    HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
	    restTemplate.exchange("http://localhosts:8081/addBook", HttpMethod.POST, entity, String.class).getBody();
	    return true;
	}
	
	public Book[] getAllBookRestTemplate(){
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    ResponseEntity<Book[]> response= restTemplate.getForEntity("https://localhost:8081/getAllBook", Book[].class);
	    Book[] allBooks=response.getBody();
	    return allBooks;
		
	}
	
	public Author[] getAllAuthorRestTemplate(){
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    ResponseEntity<Author[]> response= restTemplate.getForEntity("https://localhost:8081/getAllAuthor", Author[].class);
	    Author[] allAuthor=response.getBody();
	    return allAuthor;
		
	}
	
	public Book getBookByIdRestTemplate(int bookId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String endPoint="http://localhosts:8081/getBook/"+bookId;
		ResponseEntity<Book> response= restTemplate.getForEntity(endPoint, Book.class);
		Book book=response.getBody();
		return book;
	}
	
	public void updateBookRestTemplate(Book book) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    book.setBookDate(LocalDate.now());
	    HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
	    restTemplate.exchange("http://localhost:8081/updateBook/"+book.getBookCode(), HttpMethod.PUT, entity, String.class).getBody();
		
	}
	
	public void deleteBookRestTemplate(int bookId) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    String endPoint="http://localhosts:8081/deleteBook/"+bookId;
	    restTemplate.exchange(endPoint, HttpMethod.DELETE, entity, String.class);
	}

}