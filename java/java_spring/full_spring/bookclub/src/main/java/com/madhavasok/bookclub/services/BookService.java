package com.madhavasok.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhavasok.bookclub.models.Book;
import com.madhavasok.bookclub.repositories.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bRepo;
	
//	allBooks
	
	public List<Book> allBooks(){
		return this.bRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return this.bRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	public Book updateBook(Book book) {
		
		return this.bRepo.save(book);
	}
}
