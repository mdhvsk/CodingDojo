package com.madhavasok.booksapistarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madhavasok.booksapistarter.models.Book;
import com.madhavasok.booksapistarter.services.BookService;

@Controller
public class BookController {
	
//	private final BookService bookService;
//    public BookController(BookService bookService){
//        this.bookService = bookService;
//    }
	
	@Autowired
	private BookService bookService;

	
	@GetMapping("/")
	public String index() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String show(Model model) {
		List<Book>listOfBooks = bookService.allBooks();
		System.out.println(listOfBooks.get(0).getTitle());
		model.addAttribute("listOfBooks", listOfBooks);
		return "show.jsp";
	}
	
	
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	System.out.println(book.getTitle());
    	model.addAttribute("currentBook", book);
    	return "show.jsp";
    }
}
