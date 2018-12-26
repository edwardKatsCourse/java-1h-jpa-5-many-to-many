package application.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entity.Author;
import application.entity.Book;
import application.service.ManyToManyService;

@RestController
public class ManyToManyController {
	
	@Autowired
	ManyToManyService model;
	
	@PostMapping(value="/addAuthor")
	public boolean addAuthor(@RequestParam (name="author") String name) {
		return model.addAuthor(name);
	}
	
	@PostMapping(value="/addBook")
	public boolean addBook(@RequestParam (name="book") String title) {
		return model.addBook(title);
	}
	
	@PostMapping(value = "/setAuthor")
	public boolean setAuthor(@RequestParam (name="book") String title, 
			                @RequestParam (name="author") String name) {
		return model.setAuthor(title, name);
	}
	
	@GetMapping(value="/getAuthorsByBook")
	public List<Author> getAuthorsByBook(@RequestParam (name="book") String title){
		return model.getBookAuthors(title);
	}
	
	@GetMapping(value="/getBooksByAuthor")
	public List<Book> getBooksByAuthor(@RequestParam (name="author") String name){
		return model.getAuthorBooks(name);
	}
	
	@DeleteMapping(value="/deleteAuthor")
	public boolean deleteAuthor(@RequestParam (name="author") String name) {
		return model.deleteAuthor(name);
	}
	
	@DeleteMapping(value="/deleteBook")
	public boolean deleteBook(@RequestParam (name="book") String title) {
		return model.deleteBook(title);
	}
	

}
