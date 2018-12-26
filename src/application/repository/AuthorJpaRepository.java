package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.Author;

public interface AuthorJpaRepository extends JpaRepository<Author, String> {

    boolean existsByName(String name);
    Author findByName(String name);
    void deleteByName(String name);

}
