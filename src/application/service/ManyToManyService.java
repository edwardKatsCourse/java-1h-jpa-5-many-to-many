package application.service;

import java.util.List;
import java.util.Set;

import application.entity.Author;
import application.entity.Book;

//1. No underscores in class names
//2. No leading "I"
//3. Classes with annotations @Service must end with "-Service" suffix


//EI_BL_007_MimshakMaasikim

//EI - EmployerInterface
//BL - Business Logic
//007 - documentation part
//Mimshak - Interface
//Maasikim - Employers

//ei_bl_006_4_hushuvKlali(....10 params)

//EI_BL_007_MimshakMaasikimImpl


//dlyType - deliveryType

public interface ManyToManyService {
	
	boolean addAuthor(String name);
	boolean addBook(String title);
	boolean setAuthor (String title, String name);
	List<Author> getBookAuthors(String title);
	List<Book> getAuthorBooks(String name);
	boolean deleteBook(String title);
	boolean deleteAuthor(String name);
}
