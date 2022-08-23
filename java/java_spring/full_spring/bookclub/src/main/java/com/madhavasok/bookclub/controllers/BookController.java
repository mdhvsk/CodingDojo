package com.madhavasok.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.madhavasok.bookclub.models.Book;
import com.madhavasok.bookclub.models.User;
import com.madhavasok.bookclub.services.BookService;
import com.madhavasok.bookclub.services.UserService;

@Controller
public class BookController {
	private final UserService uServ;
	private final BookService bServ;
	
	public BookController(UserService uServ, BookService bServ) {
		this.uServ = uServ;
		this.bServ = bServ;
	}
	
	@GetMapping("/books/new")
	public String createBookPage(Model model, HttpSession session) {
		model.addAttribute("book", new Book());

		return "createBook.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("book", bServ.findBook(id));
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);

		return "book.jsp";
	}
	
	@PostMapping("/createBook")
	public String createBook(@Valid @ModelAttribute("book") Book book, Model model, BindingResult result, HttpSession session) {
		if(result.hasErrors()) { 
			return "createBook.jsp";
		}
		
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);
		book.setUser(user);
		bServ.createBook(book);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBookPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("book", new Book());
		model.addAttribute("currentBook", bServ.findBook(id));

		return "editBook.jsp";
	}
	
	@PutMapping("/editBook")
	public String editBook(@Valid @ModelAttribute("book") Book book, Model model, BindingResult result, HttpSession session) {
		if(result.hasErrors()) { 
			return "createBook.jsp";
		}
		System.out.println("its ok");
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);
		bServ.updateBook(book);
		return "redirect:/dashboard";
	}
	
	
	

}
