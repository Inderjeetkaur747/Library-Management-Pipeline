package com.training.advancejava.librarymanagement.dao;



import org.springframework.data.repository.CrudRepository;

import com.training.advancejava.librarymanagement.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
