package com.model;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element{
    private List<Author> authors;
    private List<Element> content;
    private TableOfContent tableOfContent;
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
