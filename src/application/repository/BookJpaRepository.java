package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.Book;

public interface BookJpaRepository extends JpaRepository<Book, String>{
    boolean existsByTitle(String title);
    Book findByTitle(String title);
    void deleteByTitle(String title);
}
