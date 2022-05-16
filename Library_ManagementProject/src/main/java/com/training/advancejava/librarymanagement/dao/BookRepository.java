package com.training.advancejava.librarymanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.advancejava.librarymanagement.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
