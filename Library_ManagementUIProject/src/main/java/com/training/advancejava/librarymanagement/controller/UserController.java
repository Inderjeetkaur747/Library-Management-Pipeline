package com.training.advancejava.librarymanagement.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.advancejava.librarymanagement.entities.Author;
import com.training.advancejava.librarymanagement.entities.Book;
import com.training.advancejava.librarymanagement.entities.User;
import com.training.advancejava.librarymanagement.services.RestTemplateService;
import com.training.advancejava.librarymanagement.services.UserRepositoryServices;



@RestController
public class UserController {

	@Autowired
	UserRepositoryServices userRepositoryService;
	
	
	
	@Autowired
	RestTemplateService restTemplateService;
	
	@GetMapping("/login")
	public ModelAndView login(Model model) {
		model.addAttribute("loginData",new User());
		
		return new ModelAndView("login");
	}
	
	@GetMapping("/bookManagement")
	public ModelAndView bookManagement(Model model) {
		model.addAttribute("loginData",new User());
		Book[] allBooks=this.restTemplateService.getAllBookRestTemplate();

		if(allBooks.length>0)
			model.addAttribute("allBooks",allBooks);
		
		return new ModelAndView("bookManagement");
	}
	
	
	
	@PostMapping("/processForm")
	public ModelAndView processForm(@Valid @ModelAttribute("loginData") User user, BindingResult result,Model model, HttpSession session) {
		if(result.hasErrors()) {
	
			return new ModelAndView("/login");
		}
		
		boolean validUser=this.userRepositoryService.verifyUser(user.getUserId(), user.getUserPassword());
		
		if(validUser) {
			session.removeAttribute("userId");
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("isValidLogin", "true");
			
			Book[] allBooks=this.restTemplateService.getAllBookRestTemplate();

			if(allBooks.length>0)
				model.addAttribute("allBooks",allBooks);
			
			
			return new ModelAndView("/bookManagement");
		}
			
		else {
			session.setAttribute("isValidLogin", "false");
			return new ModelAndView("login");
		}
	}
	

	
	
	@GetMapping("/addBook")
	public ModelAndView addNewBook(Model model) {
		Author[] allAuthors=this.restTemplateService.getAllAuthorRestTemplate();
		model.addAttribute("allAuthors",allAuthors);
		return new ModelAndView("addBook");
	}
	
	@PostMapping("/addBookForm")
	public ModelAndView addMyBook(@Valid @ModelAttribute("book") Book book, BindingResult result,Model model, HttpSession session) {
	     boolean check=this.restTemplateService.addBookRestTemplate(book);
	     Book[] allBooks=this.restTemplateService.getAllBookRestTemplate();
	     if(check) {
	    	 session.setAttribute("bookAlreadyExist", "false");
	     }else {
	    	 session.setAttribute("bookAlreadyExist", "true");
	     }
	     
	     
			if(allBooks.length>0)
				model.addAttribute("allBooks",allBooks);
	     return new ModelAndView("bookManagement");    
	}
	
	@GetMapping("/fetchAllBook")
	public ResponseEntity<Book[]> fetchAllBook() {
		Book[] res=this.restTemplateService.getAllBookRestTemplate();
		return new ResponseEntity<Book[]>(res,HttpStatus.OK);
	}
	
	@GetMapping("/deleteBook/{bookId}")
	public ModelAndView deleteBook(@PathVariable("bookId") int bookId, Model model) {
		this.restTemplateService.deleteBookRestTemplate(bookId);
		Book[] allBooks=this.restTemplateService.getAllBookRestTemplate();

		if(allBooks.length>0)
			model.addAttribute("allBooks",allBooks);
		return new ModelAndView("bookManagement");
	}
	
	@PostMapping("/editBookForm")
	public ModelAndView editBook(Book book, Model model) {
		this.restTemplateService.updateBookRestTemplate(book);
		Book[] allBooks=this.restTemplateService.getAllBookRestTemplate();
		if(allBooks.length>0)
			model.addAttribute("allBooks",allBooks);
		return new ModelAndView("bookManagement");
		
	}
	
	@GetMapping("/editBook/{bookId}")
	public ModelAndView editBook(@PathVariable("bookId") int bookId, Model model) {
		Book oldBook=this.restTemplateService.getBookByIdRestTemplate(bookId);
		Author[] allAuthors=this.restTemplateService.getAllAuthorRestTemplate();
		model.addAttribute("allAuthors",allAuthors);
		model.addAttribute("oldBook",oldBook);
		return new ModelAndView("editBook");
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(Model model, HttpSession session) {
		session.removeAttribute("userId");
		session.invalidate();
		model.addAttribute("loginData",new User());
		return new ModelAndView("redirect:"+"login");
	}
}
