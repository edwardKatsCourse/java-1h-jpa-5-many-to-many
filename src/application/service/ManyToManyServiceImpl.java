package application.service;

import application.entity.Author;
import application.entity.Book;
import application.repository.AuthorJpaRepository;
import application.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyToManyServiceImpl implements ManyToManyService {

    @Autowired
    AuthorJpaRepository authorRepository;

    @Autowired
    BookJpaRepository bookRepository;

    @Transactional
    @Override
    public boolean addAuthor(String name) {
        if (authorRepository.existsByName(name)) {
            return false;
        }

        authorRepository.save(new Author(name));

        return true;
    }

    @Override
    public boolean addBook(String title) {
        if (bookRepository.existsByTitle(title)) {
            return false;
        }
        bookRepository.save(new Book(title));
        return true;
    }

    @Override
    public boolean setAuthor(String title, String name) {
        addBook(title);
        addAuthor(name);

        Author author = authorRepository.findByName(name);
        Book book = bookRepository.findByTitle(title);

        book.getAuthors().add(author);
        author.getBooks().add(book);
        bookRepository.save(book);

        return true;
    }

    @Override
    public List<Author> getBookAuthors(String title) {
        Book book = bookRepository.findByTitle(title);
        return book == null ? new ArrayList<>() : book.getAuthors();
    }

    @Override
    public List<Book> getAuthorBooks(String name) {
        Author author = authorRepository.findByName(name);
        return author == null ? new ArrayList<>() : author.getBooks();
    }

    @Override
    public boolean deleteBook(String title) {
        if (!bookRepository.existsByTitle(title)) {
            return false;
        }
        bookRepository.deleteByTitle(title);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteAuthor(String name) {
        if (!authorRepository.existsByName(name)) {
            return false;
        }
        authorRepository.deleteByName(name);
        return true;
    }

}
