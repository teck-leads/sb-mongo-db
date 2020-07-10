package com.techleads.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Book;
import com.techleads.app.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@PostMapping(value = { "/books" })
	public String saveBook(@RequestBody Book book) {
		Book save = repository.save(book);
		return "Book is saved in mongoDB:  " + save;

	}

	@GetMapping(value = { "/books" })
	public List<Book> findAllBooks() {
		List<Book> findAll = repository.findAll();
		return findAll;

	}

	@GetMapping(value = { "/books/{id}" })
	public Book findBookById(@PathVariable("id") Integer id) {
		Optional<Book> findById = repository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return new Book();
		}

	}

	@DeleteMapping(value = { "/books/{id}" })
	public String deleteBook(@PathVariable("id") Integer id) {
		repository.deleteById(id);
		return "Book is deleted from mongoDB:  " + id;

	}

}
