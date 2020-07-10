package com.techleads.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techleads.app.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
