package com.model;

import com.interfaces.Element;
import com.interfaces.Visitor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(force = true)
@Entity
public class Book extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "book")
    private List<Author> authors;
    @ManyToMany(cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE})
    @JoinTable(
            name = "element_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private List<Element> content;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private TableOfContent tableOfContent;
    @Column(name = "title")
    private String title;

    public Book(String title){
        this.content = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.title = title;
    }

    public void addContent(Element e){
        this.content.add(e);
    }

    public List<Element> getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public TableOfContent getTableOfContent() {
        return tableOfContent;
    }

    public void setTableOfContent(TableOfContent tableOfContent) {
        this.tableOfContent = tableOfContent;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
