package application.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String name;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        super();
        this.name = name;
    }


}
